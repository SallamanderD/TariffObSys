<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <div class="container">
        <jsp:include page="/mainmenu"></jsp:include>
    </div>
    <body>
    <c:choose>
        <c:when test="${not empty results}">
            <div class="container col-lg-6 col-lg-offset-3">
                <ul class="list-group">
                    <c:forEach var="telephone" items="${results}" varStatus="loop">
                        <li class="list-group-item"><a href="/telephone/${telephone.id}">${telephone.number}</a></li>
                        <li class="list-group-item">${telephone.text}</li>
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