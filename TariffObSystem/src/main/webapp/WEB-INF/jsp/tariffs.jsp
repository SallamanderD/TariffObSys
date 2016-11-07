<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <title>TOS: Tariffs</title>
</head>
<jsp:include page="/mainmenu"></jsp:include>
<body>
<c:choose>
    <c:when test="${not empty tariffs}">
        <ul>
            <c:forEach var="listValue" items="${tariffs}">
                <li>${listValue.name}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        Oops! Empty list.
    </c:otherwise>
</c:choose>
</body>
</html>