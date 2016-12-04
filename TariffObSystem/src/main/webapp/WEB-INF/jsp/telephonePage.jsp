<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ru">
<head>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<div class="container tariffContainer" style="margin-top: 5%; max-width: 74%">
    <h2><b>${telephone.number}</b></h2>
    <br>
    ${telephone.text}
    <hr>
    <jsp:include page="/telephoneCommentary">
        <jsp:param name="telephoneId" value="${telephone.id}"/>
    </jsp:include>
</div>
</body>
</html>