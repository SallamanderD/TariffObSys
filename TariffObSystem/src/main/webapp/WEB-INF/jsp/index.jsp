<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>

    </head>
    <jsp:include page="/mainmenu"></jsp:include>
    <body>
    <h2>Homepage</h2>
    <h4>Empty page, but if designer try to do something here will be something cool :3</h4>
    <%--<c:choose>
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
    </c:choose>--%>
    </body>
</html>