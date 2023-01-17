package com.example.homework4client;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите логин: ");
            String login = scanner.nextLine();
            Thread th = new Thread(new GetThread(login));//передача в поток логина для фиксации личных сообщений
            th.setDaemon(true);
            th.start();

            System.out.println("Если вы хотите увидеть список активных пользователей, наберите '/users' " +
                                "в противном случае нажмите 'Enter'"); //вывод списка активных пользователей
            String textuser = scanner.nextLine();
            if (textuser.equals("/users")) {
                new GetThread(login).printUsers();
            }

            System.out.println("Введите свое сообщение в форму <@login:message> где @login это человек, которому вы " +
                    "желаете написать в приват. Если желаете написать всем в чат, форма: <@All:message>. " +
                    "Где message - это текст сообщения");
            while (true) {
                String text = scanner.nextLine();
                if (text.isEmpty()) break;
                String to= text.substring(1,text.indexOf(':')); //+ чтение логинов
                text=text.substring(text.indexOf(":")+1,text.length());

                Message m = new Message(login, text, to); //+ сохранение пере5менной "to"
                int res = m.send(Utils.getURL() + "/add");

                if (res != 200) { // 200 OK
                    System.out.println("Ошибка HTTP: " + res);
                    return;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
