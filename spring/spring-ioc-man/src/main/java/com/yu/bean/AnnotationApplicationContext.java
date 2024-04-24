package com.yu.bean;

import com.yu.anno.Bean;
import com.yu.anno.Di;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName AnnotationApplicationContext
 * @Description TODO
 * @Author YU
 * @Date 2024/4/7 18:10
 * @Version 1.0
 **/
public class AnnotationApplicationContext implements ApplicationContext{

    //常见map集合放bean对象
    private  Map<Class,Object> beanFactory = new HashMap<>();
    private static String rootPath;

    // 返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }
    // 设置包扫描规则
    public AnnotationApplicationContext(String basePackage){
        String packagePath = basePackage.replaceAll("\\.","\\\\");

        // 获取包绝对路径
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");

                // 获取其包前面路径部分
                rootPath = filePath.substring(0,filePath.length()-packagePath.length());
                // 包扫描
                loadBean(new File(filePath));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 属性注入
        loadDi();
    }

    private void loadDi() {
        // 实例化对象在beanFactory的集合里
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for(Map.Entry<Class,Object> entry:entries){
            Object obj = entry.getValue();
            Class<?> clazz = obj.getClass();

            Field[] declaredFields = clazz.getDeclaredFields();
            for(Field filed:declaredFields){
                Di annotation = filed.getAnnotation(Di.class);
                if(annotation != null){
                    filed.setAccessible(true);
                    try {
                        filed.set(obj,beanFactory.get(filed.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


    private void loadBean(File file) throws Exception {
        // 判断是否文件夹
        if(file.isDirectory()){
            // 获取文件夹所有内容
            File[] childrenFiles = file.listFiles();
            // 判断文件夹内容为空
            if(childrenFiles == null || childrenFiles.length == 0){
                return;
            }
            for(File child :childrenFiles){
                if(child.isDirectory()){
                    loadBean(child);
                }else{
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length()-1);
                    // 判断是否为class文件
                    if(pathWithClass.contains(".class")){
                        String allName = pathWithClass.replaceAll("\\\\", ".")
                                .replace(".class", "");

                        Class<?> clazz = Class.forName(allName);
                        if(!clazz.isInterface()){
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if(annotation != null){
                                Object instance = clazz.getDeclaredConstructor().newInstance();
                                if(clazz.getInterfaces().length >0){
                                    beanFactory.put(clazz.getInterfaces()[0],instance);
                                }else{
                                    beanFactory.put(clazz,instance);
                                }
                            }
                        }
                    }
                }
            }
        }


    }
}
