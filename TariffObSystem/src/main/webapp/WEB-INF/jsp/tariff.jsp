<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<div class="container col-lg-5 col-lg-offset-3" style="margin-top: 5%">
${tariff.name}
<br>
${tariff.description}
<table class="table table-striped table-inverse">
    <thead>
    <tr>
        <th>Parameter</th>
        <th>Value</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="param" items="${tariff.parameters}" varStatus="loop">
        <tr>
            <td>${tariff.parameters.get(loop.index).key.name}</td>
            <td>${tariff.parameters.get(loop.index).value}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    </div>
</body>
</html>