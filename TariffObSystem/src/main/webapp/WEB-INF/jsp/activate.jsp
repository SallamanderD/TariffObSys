<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <title>TOS: Confirm Mail</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>

<div class="container">
    <h2>We sent code on your email. Pls, enter it this. <a target="_blank" href="${mail}"> Go To Email</a></h2>

    <form method="POST" action="/activate">
    <div class="row">
        <div class="form-group col-md-3">
            <label for="code">Your code:</label>
            <input type="text" name="code" class="form-control" id="code">
        </div>

    </div>
        <button type="submit" class="btn btn-default">Activate</button>
    </form>
</div>
</body>
</html>