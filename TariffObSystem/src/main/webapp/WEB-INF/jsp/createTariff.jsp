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
    <h3>Создание тарифа</h3>
    <form action="/createTariff" method="post">
        <label for="name">Название:</label>
        <input type="text" class="form-control" name="name" id="name">
        <label>Оператор</label>
        <select class="form-control" name="operator">
            <c:forEach var="operator" items="${operators}">
                <option value="${operator.id}">${operator.name}</option>
            </c:forEach>
        </select>
        <label for="shortDescription">Короткое описание:</label>
        <textarea class="form-control" name="shortDescription" style="min-width: 100%; max-width: 100%" placeholder="Короткое описание(выводится на странице просмотра всех тарифов)" id="shortDescription"
                  rows="5" cols="77"></textarea>
        <label for="description">Описание:</label>
        <textarea class="form-control" name="description" style="min-width: 100%" placeholder="Полное описание(выводится на странице просмотра тарифа)" id="description"
                  rows="5" cols="77"></textarea>
        <h4>Параметры: </h4>
        <label for="count">Цена:</label>
        <input type="text" class="form-control" name="count" id="count">
        <label for="threeG">3G:</label>
        <input type="text" class="form-control" name="threeG" id="threeG">
        <label for="inCalls">Звонки в сети, минут:</label>
        <input type="text" class="form-control" name="inCalls" id="inCalls">
        <label for="outCalls">Звонки на других операторов, минут:</label>
        <input type="text" class="form-control" name="outCalls" id="outCalls">
        <label>Безлимит соц.сети:</label>
        <div class="checkbox">
            <label><input type="checkbox" name="vk" value="true">VK</label>
        </div>
        <div class="checkbox">
            <label><input type="checkbox" name="fb" value="true">Facebook</label>
        </div>
        <div class="checkbox">
            <label><input type="checkbox" name="ok" value="true">OK</label>
        </div>
        <div class="checkbox">
            <label><input type="checkbox" name="tw" value="true">Twitter</label>
        </div>
        <label for="sms">SMS:</label>
        <input type="text" class="form-control" name="sms" id="sms">
        <button class="btn mysearch btn-success" style="margin-top: 1%" type="submit">Создать</button>
    </form>
</div>
</body>
</html>