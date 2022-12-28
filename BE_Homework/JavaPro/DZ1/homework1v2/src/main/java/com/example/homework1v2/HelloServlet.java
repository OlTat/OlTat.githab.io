package com.example.homework1v2;

/*
 *  Сделать простое приложение на сервлете, которое принимает запрос типа /hello?name=xxxx
 *  и выводит на странице сообщение Hello, xxxx.
 */

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    static final String TEMPLATE = "<html>" +
            "<head><title>com.example.homework1v2</title></head>" +
            "<body><h1>%s</h1></body></html>";

    // GET request: http://localhost:8888/hello?name=Servlet
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String msg;

        if ("Servlet".equals(name))
            msg = "Hello Servlet";
        else {
            msg = "Wrong parameters";
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // bad request
        }

        resp.setContentType("text/html"); // Content-Type: text/html
        PrintWriter pw = resp.getWriter();
        pw.println(String.format(TEMPLATE, msg));
    }
}
