<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h2>${telephone.number}</h2>
    <br>
    ${telephone.text}
    <hr>
    <jsp:include page="/telephoneCommentary">
        <jsp:param name="telephoneId" value="${telephone.id}"/>
    </jsp:include>
</body>
</html>