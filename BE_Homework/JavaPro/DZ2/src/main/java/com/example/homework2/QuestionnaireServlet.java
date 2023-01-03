package com.example.homework2;

/*
 *  Сделать проект-анкету, который позволяет через форму ввести ответы на 2-3 вопроса, например:
 *  1) Do you love Java?
 *      a) Yes
 *      b) No
 *  2) Do you love Python?
 *      a) Yes
 *      b) No
 *  Далее ответы сохраняються на бэкэнде и после заполнения анкеты пользователю выводится таблица
 *  со всеми результатами заполнения.
 */

import jakarta.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class QuestionnaireServlet extends HttpServlet {

    static final String TEMP1 =
            "<html>" +
                    "<head>" +
                        "<style>" +
                            "h1{" +
                                "width: 300px;" +
                                "height: 34px;" +
                                "border: 3px solid green;" +
                                "margin-bottom: 0;" +
                                "display: flex;" +
                                "font-size: 26px;" +
                            "}" +
                            "span{" +
                                "font-size: 40px;" +
                                "color: green;" +
                                "display: flex;" +
                                "align-items: flex-end" +
                            "}" +
                        "</style>" +
                        "<title>" +
                            "com.example.homework2" +
                        "</title>" +
                    "</head>" +
                    "<body>" +
                        "<h1>" +
                            "%s__" +
                            "<span>|</span>" + "%s" +
                        "</h1>" +
                    "<body>" +
            "</html>";

   static final String TEMPLATE =
           "<html>" +
                   "<head>" +
                       "<style>" +
                           "h1{" +
                               "width: 300px;" +
                               "height: 34px;" +
                               "border: 3px solid green;" +
                               "margin-top: 0;" +
                               "display: flex;" +
                               "font-size: 26px;" +
                           "}" +
                           "span{" +
                               "font-size: 40px;" +
                               "color: green;" +
                               "display: flex;" +
                               "align-items: flex-end" +
                           "}" +
                       "</style>" +
                       "<title>" +
                           "com.example.homework2" +
                       "</title>" +
                   "</head>" +
                   "<body>" +
                       "<h1>" +
                           "%s" +
                           "<span>|</span>" + "%s" +
                       "</h1>" +
                       "<br><a href=/index.html>GO Back</a>" +
                   "<body>" +
           "</html>";

    @Override
   public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String java = req.getParameter("Java");
        String python = req.getParameter("Python");
        String msg;
        String msg2;
        String m1;
        String m2;

        if ("Yes".equals(java) && "Yes".equals(python)) {
            msg = "Do you love Java?";
            msg2 = "Do you love Python?";
            m1 = "Yes";
            m2 = "Yes";
        }
        else if ("No".equals(java) && "No".equals(python)) {
            msg = "Do you love Java?";
            msg2 = "Do you love Python?";
            m1 = "No";
            m2 = "No";
        }
        else if ("Yes".equals(java) && "No".equals(python)) {
            msg = "Do you love Java?";
            msg2 = "Do you love Python?";
            m1 = "Java";
            m2 = "No";
        }
        else if ("No".equals(java) && "Yes".equals(python)) {
            msg = "Do you love Java?";
            msg2 = "Do you love Python?";
            m1 = "No";
            m2 = "Yes";
        }
        else {
            msg = "Wrong parameters";
            msg2 = "Wrong parameters";
            m1 = "";
            m2 = "";
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // bad request
        }
        resp.getWriter().println(String.format(TEMP1, msg, m1));
        resp.getWriter().println(String.format(TEMPLATE, msg2, m2));
    }
}
