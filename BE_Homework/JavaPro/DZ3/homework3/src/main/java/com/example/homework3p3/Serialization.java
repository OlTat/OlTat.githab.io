package com.example.homework3p3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public class Serialization {
    public void Serialization(Object obj) throws IllegalAccessException, FileNotFoundException {
        Class<?> cls = Person.class;
        Field[] fields = cls.getDeclaredFields();

        PrintWriter pw = new PrintWriter("Person.txt");
        for (Field field : fields) {

            // Определение факта наличия аннотации Save у поля.
            // В случае наличия, добавление в файл имени и значения переменной.

            if (field.isAnnotationPresent(Save.class)) {
                field.trySetAccessible();
                String varName = field.getName();
                String value = field.get(obj).toString();
                pw.println(varName + " : " + value);
            }
        }
        pw.close();
    }
}
