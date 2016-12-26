<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
    <meta charset="utf-8">
    <title>TOS: Панель Администратора</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div id="profileContainer" class="container " style="margin-bottom: 5%">
    <h3>${massage}</h3>
    <h2>Панель администратора</h2>
    <hr/>
    <h4>Удаление тарифов:</h4>
    <div class="row">
        <div class="col-md-9">
            <div class="form-group">
                <select class="form-control" id="tariffSelect">
                    <c:forEach var="tariff" items="${tariffs}">
                        <option value="${tariff.id}">${tariff.name} || id: ${tariff.id}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="button" onclick="post('deleteTariff', {tariffId: document.getElementById('tariffSelect').value})" class="btn btn-default" value="Удалить">
        </div>
    </div>
    <hr/>
    <h4>Удаление телефонов:</h4>
    <div class="row">
        <div class="col-md-9">
            <div class="form-group">
                <input type="number" id="telephone" class="form-control" placeholder="Введите номер телефона">
            </div>
            <input type="button" onclick="post('/deleteTelephone', {telephone: document.getElementById('telephone').value})" class="btn btn-default" value="Удалить">
            <a href="/allTelephones"><button class="btn btn-success">Просмотр телефонов</button></a>
        </div>
    </div>
    <hr/>
    <h4>Удаление комментариев к тарифам:</h4>
    <div class="row">
        <div class="col-md-9">
            <div class="form-group">
                <input type="number" id="tariffCommentary" class="form-control" placeholder="Введите id комментария">
            </div>
            <input type="button" onclick="post('/deleteTariffCommentary', {id: document.getElementById('tariffCommentary').value, authorId: 0, tariffId: 0})" class="btn btn-default" value="Удалить">
            <a href="/allTariffCommentaries"><button class="btn btn-success">Просмотр комментариев</button></a>
        </div>
    </div>
    <hr/>
    <h4>Удаление комментариев к телефонам:</h4>
    <div class="row">
        <div class="col-md-9">
            <div class="form-group">
                <input type="number" id="telephoneCommentary" class="form-control" placeholder="Введите id комментария">
            </div>
            <input type="button" onclick="post('/deleteTelephoneCommentary', {id: document.getElementById('telephoneCommentary').value, authorId: 0, telephoneId: 0})" class="btn btn-default" value="Удалить">
            <a href="/allTelephoneCommentaries"><button class="btn btn-success">Просмотр комментариев</button></a>
        </div>
    </div>
    <hr/>
    <h4>Работа с пользователями:</h4>
    <div class="row">
        <div class="col-md-9">
            <div class="form-group">
                <input type="number" id="userId" class="form-control" placeholder="Введите id пользователя">
            </div>
            <input type="button" onclick="post('/banUser', {id: document.getElementById('userId').value})" class="btn btn-default" value="Забанить">
            <input type="button" onclick="post('/unbanUser', {id: document.getElementById('userId').value})" class="btn btn-default" value="Разбанить">
            <a href="/allUsers"><button class="btn btn-success">Просмотр пользователей</button></a>
        </div>
    </div>
    <hr>
    <hr>
    <button onclick="post('/createTariff', 0, 'get')" class="btn btn-success" style="margin-bottom: 3%">Создать тариф</button>

</div>
</body>
</html>