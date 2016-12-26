<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
    <meta charset="utf-8">
    <title>TOS: Создание тел.</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div id="profileContainer" class="container " style="margin-bottom: 5%">
    <form action="/createTelephone" method="post">
        <label for="telephone">Телефон:</label>
        <input type="text" class="form-control" name="telephone" id="telephone">
        <label for="description">Описание:</label>
        <textarea class="form-control" name="description" style="min-width: 100%" placeholder="Ваш комментарий" id="description"
                  rows="5" cols="77"></textarea>
        <button class="btn mysearch btn-success" style="margin-top: 1%" type="submit">Отправить</button>
    </form>
</div>
</body>
</html>