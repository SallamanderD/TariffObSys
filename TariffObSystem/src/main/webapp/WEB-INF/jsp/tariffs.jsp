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
                                        <tr data-status="vodafone">
                                            <td>
                                                <div class="media">
                                                    <div class="media-body">
                                                        <h4 class="title">
                                                        ${loop.index + 1}) <a href="/tariff/${listValue.id}">${listValue.name}</a>
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