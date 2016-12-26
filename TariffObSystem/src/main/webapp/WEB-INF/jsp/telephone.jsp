<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <div class="container">
        <jsp:include page="/mainmenu"></jsp:include>
    </div>
    <body>
    <div class="container" style="margin-top: 5%">
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4">
                <div class="panel panel-default">
                    <c:choose>
                    <c:when test="${not empty results}">
                        <div class="panel-heading">
                            <div class="update-nag">
                                <div class="update-split update-success"><i class="glyphicon glyphicon-hand-down"></i></div>
                                <div class="update-text">Вот что нам удалось найти </div>
                            </div>
                        </div>
                        <ul class="list-group">
                            <c:forEach var="telephone" items="${results}" varStatus="loop">
                            <li class="list-group-item"><a href="/telephone/${telephone.id}">${telephone.number}</a></li>
                            </c:forEach>
                        </ul>
                    </c:when>
                        <c:otherwise>
                            <div class="col-md-12">
                                <div class="update-nag">
                                    <div class="update-split update-danger"><i class="glyphicon glyphicon-warning-sign"></i></div>
                                    <div class="update-text"> <strong>Oops!</strong> Такого номера нет в базе( </div>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>