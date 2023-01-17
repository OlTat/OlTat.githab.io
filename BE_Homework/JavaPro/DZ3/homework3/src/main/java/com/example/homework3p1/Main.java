package com.example.homework3p1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        Check check = new Check();
        Class<?> cls = Check.class;

        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test t = method.getAnnotation(Test.class);
                try {
                    method.invoke(check, t.a(), t.b());
                    int a = t.a();
                    int b = t.b();
                    check.test(a, b);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
