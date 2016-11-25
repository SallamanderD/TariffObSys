<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
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
                <c:forEach var="listValue" items="${tariffs}">
                    <li class="list-group-item">
                        <p><a href="tariff/${listValue.id}">${listValue.name}</a></p>
                        <p>${listValue.shortDescription}</p>
                        <p>Operator: ${listValue.operator.name}</p>
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