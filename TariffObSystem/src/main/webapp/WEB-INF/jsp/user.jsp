<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <meta charset="utf-8">
    <title>TOS: ${user.username}</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
    <body>

    <div class="container" style="margin-top: 5%">
        <h2>Profile</h2>
        <hr/>
        <div class="row">
            <div class="form-group col-md-3">
                <p class="lead">Your Username: </p>
                <p class="lead">Your Name: </p>
                <p class="lead">Your Surname: </p>
                <p class="lead">Your Email: </p>
            </div>
            <div class="form-group">
                <p class="lead"><mark>${user.username}</mark></p>
                <p class="lead"><mark>${user.name}</mark></p>
                <p class="lead"><mark>${user.surname}</mark></p>
                <p class="lead"><mark>${user.mail}</mark></p>
            </div>
        </div>
        <a href="changeUser"><button type="submit" class="btn btn-default">Change Data</button></a>
        <a href="changePassword"><button type="submit" class="btn btn-default">Change Password</button></a>
        <hr/>
    </div>
    </body>
</html>