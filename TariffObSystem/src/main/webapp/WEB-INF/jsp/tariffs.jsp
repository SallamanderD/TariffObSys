<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <c:when test="${not empty operators}">
            <ul class="list-group">
                <c:forEach var="operValue" items="${operators}">
                    <c:choose>
                    <c:when test="${not empty operValue.tariffs}">
                        <ul class="list-group">
                            <c:forEach var="listValue" items="${operValue.tariffs}">
                                <li class="list-group-item">
                                    <p>Name: ${listValue.name}</p>
                                    <p>Description: ${listValue.description}</p>
                                    <p>Operator: ${operValue.name}</p>
                                    <table class="table table-striped table-inverse">
                                        <thead>
                                        <tr>
                                            <th>Parameter</th>
                                            <th>Value</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="param" items="${listValue.parameters}" varStatus="loop">
                                            <tr>
                                                <td>${listValue.parameters.get(loop.index).key.name}</td>
                                                <td>${listValue.parameters.get(loop.index).value}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:when>
                    </c:choose>
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