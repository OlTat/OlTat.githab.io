package com.example.homework2v2;

import jakarta.servlet.http.*;
import java.io.IOException;

public class QuestionnaireServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String java = request.getParameter("java");
        String python = request.getParameter("python");

        if (("Yes".equals(java) || "No".equals(java)) && ("Yes".equals(python) || "No".equals(python))) {
            HttpSession session = request.getSession(true);
            session.setAttribute("answer1", java);
            session.setAttribute("answer2", python);
        }
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String par = request.getParameter("a");
        HttpSession session = request.getSession(false);

        if ("exit".equals(par) && (session != null)) {
            session.removeAttribute("answer1");
            session.removeAttribute("answer2");
        }
        response.sendRedirect("index.jsp");
    }
}
