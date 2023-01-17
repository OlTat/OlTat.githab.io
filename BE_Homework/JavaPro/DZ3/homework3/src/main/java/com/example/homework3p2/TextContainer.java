package com.example.homework3p2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

@SaveTo
public class TextContainer {
//    String text = "Hello World. My name is Oleg.";

    String text;

    public TextContainer(String text) {
        this.text = text;
    }

    public TextContainer() {
        super();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextContainer{" +
                "text='" + text + '\'' +
                '}';
    }

    @Saver
    public void save(String text, String filePath)  {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фразу для передачи: ");
        text = scanner.nextLine();

        File file = new File(filePath);
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(text);
        }catch (FileNotFoundException e ){
            e.printStackTrace();
        }
    }
}
