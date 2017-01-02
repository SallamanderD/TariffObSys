<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ru">
<head>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<div class="container tariffContainer" style="margin-top: 5%; max-width: 75%">
    <h2>Сравнить</h2>
    <br>
    <table class="table table-striped table-inverse">
        <thead>
        <tr>
            <th></th>
            <th>${firstTariff.name}</th>
            <th>${secondTariff.name}</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="param" items="${firstTariff.parameters}" varStatus="loop">
            <tr>
                <td>${firstTariff.parameters.get(loop.index).key.name}</td>
                <td>${firstTariff.parameters.get(loop.index).value}</td>
                <td>${secondTariff.parameters.get(loop.index).value}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <hr>
</div>
</body>
</html>