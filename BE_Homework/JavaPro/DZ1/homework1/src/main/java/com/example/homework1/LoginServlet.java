package com.example.homework1;

/*
 *  Сделать простое приложение на сервлете, которое принимает запрос типа /hello?name=xxxx
 *  и выводит на странице сообщение Hello, xxxx.
 */

import jakarta.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

    static final String TEMPLATE = "<html>" +
            "<head><title>com.example.homework1</title></head>" +
            "<body><h1>%s</h1></body></html>";

    String msg;
    String temp;
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        temp = req.getParameter("login");
        msg = "Hello, " + temp;
        resp.getWriter().println(String.format(TEMPLATE, msg));
    }
}
