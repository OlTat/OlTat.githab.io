package com.example.homework3p2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        TextContainer textcontainer = new TextContainer();
        Class<?> cls = TextContainer.class;
        if (cls.isAnnotationPresent(SaveTo.class)){
            SaveTo saveTo = cls.getAnnotation(SaveTo.class);
            try{
                Field field = cls.getDeclaredField("text");
                String text = (String)field.get(textcontainer);
                Method[] methods = cls.getMethods();
                for(Method method : methods) {
                    if (method.isAnnotationPresent(Saver.class)) {
                        method.invoke(textcontainer, text, saveTo.path());
                        String filePath = saveTo.path();
                        textcontainer.save(text, filePath);
                    }
                }
            }catch (NoSuchFieldException e) {
                e.printStackTrace();
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }catch (InvocationTargetException e){
                e.printStackTrace();
            }
        }
    }
}
