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
<div  class="container crTelContainer" style="margin-bottom: 5%">
    <h2>Добавьте телефонный номер и комментарии к нему</h2>
    <hr id="lineHr">
    <form action="/createTelephone" method="post">
        <div class="form-group">
            <label for="telephone">Телефон:</label>
            <input type="text" class="form-control" name="telephone" id="telephone">
            <span class="help-block">разделительные знаки не обязательны</span>
        </div>
        <div class="form-group">
            <label for="description">Описание:</label>
            <textarea class="form-control" name="description" style="min-width: 100%" placeholder="Ваш комментарий" id="description"
                      rows="5" cols="77"></textarea>
        </div>
        <div class="form-group">
            <button class="btn buttonSnipp" style="margin-top: 1%" type="submit">Отправить</button>
        </div>
    </form>
</div>
<div class="container">
    <jsp:include page="/footer"></jsp:include>
</div>
</body>
</html>