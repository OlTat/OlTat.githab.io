<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>com.example.homework10and11</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container">
           <h3><img height="50" width="55" src="<c:url value="../static/ukraine.png"/>"/><a href="/">Список контактов</a></h3>

            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul id="groupList" class="nav navbar-nav">
                            <li><button type="button" id="add_contact" class="btn btn-default navbar-btn">Добавить контакт</button></li>
                            <li><button type="button" id="add_group" class="btn btn-default navbar-btn">Добавить группу</button></li>
                            <li><button type="button" id="delete_contact" class="btn btn-default navbar-btn">Удалить контакт</button></li>
                            <li><button type="button" id="delete_group" class="btn btn-default navbar-btn">Удалить группу</button></li>
                            <li><button type="button" id="add_json" class="btn btn-default navbar-btn">Добавить контакты из Json</button></li>
                            <li><button type="button" id="reset" class="btn btn-default navbar-btn">Перезагрузить</button></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Группы <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/">Default</a></li>
                                    <c:forEach items="${groups}" var="group">
                                        <li><a href="/group/${group.id}">${group.name}</a></li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </ul>
                        <form class="navbar-form navbar-left" role="search" action="/search" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" name="pattern" placeholder="Поиск">
                            </div>
                            <button type="submit" class="btn btn-default">Ввод</button>
                        </form>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>

            <table class="table table-striped">
                <thead>
                <tr>
                    <td></td>
                    <td><b>Имя</b></td>
                    <td><b>Фамилия</b></td>
                    <td><b>Телефон</b></td>
                    <td><b>E-mail</b></td>
                    <td><b>Группа</b></td>
                </tr>
                </thead>
                <c:forEach items="${contacts}" var="contact">
                    <tr>
                        <td><input type="checkbox" name="toDelete[]" value="${contact.id}" id="checkbox_${contact.id}"/></td>
                        <td>${contact.name}</td>
                        <td>${contact.surname}</td>
                        <td>${contact.phone}</td>
                        <td>${contact.email}</td>
                        <c:choose>
                            <c:when test="${contact.group ne null}">
                                <td>${contact.group.name}</td>
                            </c:when>
                            <c:otherwise>
                                <td>Default</td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>

            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:if test="${allPages ne null}">
                        <c:forEach var="i" begin="1" end="${allPages}">
                            <li><a href="/?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                        </c:forEach>
                    </c:if>
                    <c:if test="${byGroupPages ne null}">
                        <c:forEach var="i" begin="1" end="${byGroupPages}">
                            <li><a href="/group/${groupId}?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                        </c:forEach>
                    </c:if>
                </ul>
            </nav>
        </div>

        <script>
            $('.dropdown-toggle').dropdown();

            $('#add_contact').click(function(){
                window.location.href='/contact_add_page';
            });

            $('#add_group').click(function(){
                window.location.href='/group_add_page';
            });

            $('#reset').click(function(){
                window.location.href='/reset';
            });

            $('#delete_group').click(function (){
                window.location.href='/delete_group';
            });

            $('#add_json').click(function (){
                window.location.href='/json';
            });

            $('#delete_contact').click(function(){
                var data = { 'toDelete[]' : []};
                $(":checked").each(function() {
                    data['toDelete[]'].push($(this).val());
                });
                $.post("/contact/delete", data, function(data, status) {
                    window.location.reload();
                });
            });
        </script>
    </body>
</html>
