package com.example.homework4client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class GetThread implements Runnable {
    private final Gson gson;
    private int n; // /get?from=n
    private String login; //добавляется переменная login для реализации фиксации личных сообщений
    private Set<String> userslist = new HashSet<>(); //список уникальных users, написавших хотя бы одно сообщение
    public GetThread(String login) {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        this.login=login; //получение login из main
    }

    @Override
    public void run() { // WebSockets
        try {
            while ( ! Thread.interrupted()) {
                URL url = new URL(Utils.getURL() + "/get?from=" + n);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();

                InputStream is = http.getInputStream();
                try {
                    byte[] buf = responseBodyToArray(is);
                    String strBuf = new String(buf, StandardCharsets.UTF_8);

                    JsonMessages list = gson.fromJson(strBuf, JsonMessages.class);
                    if (list != null) {
                        for (Message m : list.getList()) {
                            if (m.getTo().equals(login) || m.getTo().equals("All") || m.getFrom().equals(login)) {
                                // вывод сообщений, адресованных user или всем
                                System.out.println(m);
                                n++;}
                            else {
                                n++;
                            }
                        }
                    }
                } finally {
                    is.close();
                }
                Thread.sleep(500);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void printUsers() { //получение списка активных пользователей (уникальных)
        try {
            URL url = new URL(Utils.getURL() + "/get?from=" + 0);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            InputStream is = http.getInputStream();
            try {
                byte[] buf = responseBodyToArray(is);
                String strBuf = new String(buf, StandardCharsets.UTF_8);

                JsonMessages list = gson.fromJson(strBuf, JsonMessages.class);
                if (list != null) {
                    for (Message m : list.getList()) {
                        userslist.add(m.getFrom()); // из списка всех сообщений выбираются отправители помещаются в
                                                    // Set для исключения дублирования
                    }
                }
            } finally {
                System.out.println("List of users");
                userslist.add(login); // если user зашел впервые, его имени нет в списке сообщений, его необходимо
                                      // добавить в список
                System.out.println(userslist.toString());
                is.close();
            }
            Thread.interrupted();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private byte[] responseBodyToArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[10240];
        int r;
        do {
            r = is.read(buf);
            if (r > 0) bos.write(buf, 0, r);
        } while (r != -1);
        return bos.toByteArray();
    }
}
