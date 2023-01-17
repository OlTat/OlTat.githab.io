package com.example.homework3p3;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Person person = new Person(90, "Oleg", 190, "Ukraine"); //
        System.out.println(person);                                                      //
        Serialization srl = new Serialization();

        try {
            srl.Serialization(person);                                                   //
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        File personFile = new File("Person.txt");
        Deserialization des = new Deserialization();

        try {
            des.Deserialization(personFile);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
