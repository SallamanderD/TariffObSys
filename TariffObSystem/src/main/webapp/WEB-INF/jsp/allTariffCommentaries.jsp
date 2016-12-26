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
    <h2>Все комментарии к тарифам</h2>
    <hr/>
    <table class="table table-striped table-inverse">
        <thead>
        <tr>
            <th>ID</th>
            <th>ID автора</th>
            <th>ID тарифа</th>
            <th>Дата</th>
            <th>Удален</th>
            <th>Ссылка</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="comment" items="${tariffCommentaries}" varStatus="loop">
            <tr>
                <td>${comment.id}</td>
                <td>${comment.author.id}</td>
                <td>${comment.tariffId}</td>
                <td>${comment.date}</td>
                <td>${comment.deleted}</td>
                <td><a href="/tariff/${comment.tariffId}">Страница</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>