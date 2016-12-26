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
    <h2>Панель администратора</h2>
    <hr/>
    <h4>Удаление тарифов:</h4>
    <div class="row">
        <div class="col-md-9">
            <div class="form-group">
                <select class="selectpicker form-control">
                    <c:forEach var="tariff" items="${tariffs}">
                        <option>${tariff.name} || id: ${tariff.id}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" class="btn btn-default" value="Удалить">
        </div>
    </div>
    <hr/>
    <h4>Удаление тарифов:</h4>
    <div class="row">
        <div class="col-md-9">
            <div class="form-group">
                <select class="selectpicker form-control">
                    <c:forEach var="tariff" items="${tariffs}">
                        <option>${tariff.name} || id: ${tariff.id}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" class="btn btn-default" value="Удалить">
        </div>
    </div>
    <hr/>
    <h4>Удаление тарифов:</h4>
    <div class="row">
        <div class="col-md-9">
            <div class="form-group">
                <select class="selectpicker form-control">
                    <c:forEach var="tariff" items="${tariffs}">
                        <option>${tariff.name} || id: ${tariff.id}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" class="btn btn-default" value="Удалить">
        </div>
    </div>
</div>
</body>
</html>