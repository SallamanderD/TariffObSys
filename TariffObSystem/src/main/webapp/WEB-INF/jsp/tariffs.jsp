<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
    <title>TOS: Tariffs</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div class="container col-lg-5 col-lg-offset-3" style="margin-top: 5%">
    <c:choose>
        <c:when test="${not empty tariffs}">
            <ul class="list-group">
                <c:forEach var="listValue" items="${tariffs}" varStatus="loop">
                    <li class="list-group-item">
                        <p>${loop.index + 1}) <a href="/tariff/${listValue.id}">${listValue.name}</a></p>
                        <p>${listValue.shortDescription}</p>
                        <p>Operator: <a href="/tariffs/${listValue.operator.name}">${listValue.operator.name}</a></p>
                    </li>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            Oops! Empty list.
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>