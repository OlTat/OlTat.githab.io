<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <style>
        form{
            border: 5px solid darkblue;
            color: brown;
            font-size: 26px;
            font-weight: 900;
            background: burlywood;
            width: 550px;
        }
        h1{
            color: saddlebrown;
            font-size: 30px;
            font-weight: 900;
        }
        h1.dline{
            line-height: 0.4em;
        }
        table{
            border: 5px solid green;
            color: red;
            font-size: 26px;
            font-weight: 900;
            background: yellow;
        }
        tr{
            border: 5px solid blue;
            background: yellowgreen;
        }
        a{
            text-decoration: none;
            color: darkblue;
            font-size: 18px;
            font-weight: 900;
        }
    </style>
    <title>com.example.homework2v2</title>
</head>
<body>
<% String answer1 = (String)session.getAttribute("answer1"); %>
<% String answer2 = (String)session.getAttribute("answer2"); %>

<% if (answer1 == null || "".equals(answer1) || answer2 == null || "".equals(answer2)) { %>
<h1 class="dline">Вам необходимо ответить на два вопроса</h1>
<h1>(Yes или No):</h1>
<form action="/questionnaire" method="POST">
    Do you love Java?&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="java"><br><br>
    Do you love Python? <input type="text" name="python"><br><br>
    <input type="submit" />
</form>
<% } else { %>
<h1>Ваши ответы:</h1>
<table border="5">
    <tr>
        <td>Do you love Java?</td>
        <td><%= answer1 %></td>
    </tr>
    <tr>
        <td>Do you love Python?</td>
        <td><%= answer2 %></td>
    </tr>
</table>
<br>Щелкните эту ссылку, чтобы <a href="/questionnaire?a=exit">Сбросить ответы</a>
<% } %>
</body>
</html>
