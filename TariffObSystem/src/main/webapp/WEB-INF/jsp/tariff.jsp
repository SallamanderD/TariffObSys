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
        <h2>${tariff.name}</h2>
        <br>
        <table class="table table-striped table-inverse">
            <thead>
            <tr>
                <th>Параметр</th>
                <th>Значение</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="param" items="${tariff.parameters}" varStatus="loop">
                <tr>
                    <td>${tariff.parameters.get(loop.index).key.name}</td>
                    <td>${tariff.parameters.get(loop.index).value}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        ${tariff.description}
        <hr>
        <jsp:include page="/tariffCommentary">
            <jsp:param name="tariffId" value="${tariff.id}"/>
        </jsp:include>
    </div>
<div class="container">
    <jsp:include page="/footer"></jsp:include>
</div>
</body>
</html>