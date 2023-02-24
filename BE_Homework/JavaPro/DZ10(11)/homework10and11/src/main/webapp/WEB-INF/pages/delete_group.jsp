<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>com.example.homework10and11</title>

    <style>
        ul{
            list-style: none;
            display: flex;
            align-items: center;
            flex-direction: column;

        }

        li{
            text-align: center;
            height: 30px;
            width: 300px;
            background: rgb(245,245,245);
            border: solid black 1px;
            font-size: 20px;
            font-weight: bold;
           margin-bottom: 5px;
        }
        a{
            color: black;
            text-decoration: none;
        }

    </style>
</head>
<body>
<ul>
    <c:forEach items="${groups}" var="group">
      <li><a href="/delete_group/${group.id}">${group.name}</a></li>
    </c:forEach>

</ul>









</div>

</body>
</html>