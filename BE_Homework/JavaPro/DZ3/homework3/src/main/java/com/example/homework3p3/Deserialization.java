package com.example.homework3p3;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Deserialization {
    public void Deserialization(File filePerson) throws IllegalAccessException {
        Class<?> cls = Person.class;
        Field[] fields = cls.getDeclaredFields();
        Person person = new Person();

        // Считывание информации из файла.

        try (BufferedReader br = new BufferedReader(new FileReader(filePerson))) {
            String tz1 = "";
            ArrayList<String> listOfPerson = new ArrayList<>();
            for (; ; ) {
                tz1 = br.readLine();
                if (tz1 == null) {
                    break;
                }
                listOfPerson.add(tz1);
            }

            // Разбивка на имя и значение переменной.

            ArrayList<String> parsListOfPerson = new ArrayList<>();
            for (String list : listOfPerson) {
                String[] tz2 = list.split(" : ");
                for (int i = 0; i < tz2.length; i++) {
                    parsListOfPerson.add(tz2[i]);
                }
            }

            for (Field field : fields) {

                // Определение факта наличия аннотации Save у поля.

                if (field.isAnnotationPresent(Save.class)) {
                    for (int i = 0; i < parsListOfPerson.size(); i++) {
                        if (field.getName().equals(parsListOfPerson.get(i))) {
                            field.trySetAccessible();
                            Class<?> fieldType = field.getType();

                            /*
                            Если тип поля int, необходимо изменить тип данних на i-том елементе List, записав
                            их в другую переменную.
                             */

                            if (fieldType.equals(int.class)) {
                                int tz1Int = Integer.parseInt(parsListOfPerson.get(i + 1));
                                field.set(person, tz1Int);
                            } else field.set(person, parsListOfPerson.get(i + 1));
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(person);
    }
}
