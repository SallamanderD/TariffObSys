<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>TOS: Tariffs</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div class="container" style="margin-top: 4%">
    <div class="row">
        <section class="content">
            <div class="col-md-8 col-md-offset-2">
                <h3><b>List of available tariffs</b></h3>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="table-container">
                            <table class="table table-filter">
                                <tbody>
                                <c:choose>
                                    <c:when test="${not empty tariffs}">
                                        <c:forEach var="listValue" items="${tariffs}" varStatus="loop">
                                        <tr onclick="post('/tariff/${listValue.id}')">
                                            <td>
                                                <div class="media">
                                                    <div class="media-body">
                                                        <span class="media-meta pull-right">February 13, 2016</span>
                                                        <h4 class="title">
                                                            <img src="/ico/${listValue.operator.name}.png" height="18" width="18"/> ${listValue.name}
                                                            <span class="pull-right vodafone"><a href="/tariffs/${listValue.operator.name}">${listValue.operator.name}</a></span>
                                                        </h4>
                                                        <p class="summary">${listValue.shortDescription}</p>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        Oops! Empty list.
                                    </c:otherwise>
                                </c:choose>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
</body>
</html>