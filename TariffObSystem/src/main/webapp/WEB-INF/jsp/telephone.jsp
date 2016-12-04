<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <div class="container">
        <jsp:include page="/mainmenu"></jsp:include>
    </div>
    <body>
    <c:choose>
        <c:when test="${not empty results}">
            <div class="container">
                <ul class="list-group">
                    <c:forEach var="telephone" items="${results}" varStatus="loop">
                        <li class="list-group-item"><a href="/telephone/${telephone.id}">${telephone.number}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </c:when>
        <c:otherwise>
            Oops! Empty list.
        </c:otherwise>
    </c:choose>
    </body>
</html>