<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
    <meta charset="utf-8">
    <title>TOS: ${user.username}</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div id="profileContainer" class="container " style="margin-bottom: 5%">
    <h2>Все пользователи</h2>
    <hr/>
    <table class="table table-striped table-inverse">
        <thead>
        <tr>
            <th>Логин</th>
            <th>ID</th>
            <th>Бан</th>
            <th>Эл. почта</th>
            <th>Роль</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}" varStatus="loop">
            <tr>
                <td>${user.username}</td>
                <td>${user.id}</td>
                <td>${user.banned}</td>
                <td>${user.mail}</td>
                <td>${user.role.value}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>