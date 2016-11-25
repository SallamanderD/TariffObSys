<!DOCTYPE html>
<html lang="en">
<head>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <title>TOS: Change Profile</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div class="container">
    <h3>Sign In</h3>
    <p>${error}</p>
    <form method="POST" action="/changePassword">
        <div class="row">
            <div class="form-group col-md-3">
                <label for="pwd">Old Password:</label>
                <input type="password" name="oldpassword" class="form-control" id="pwd">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-3">
                <label for="pwd">Password:</label>
                <input type="password" name="password" class="form-control" id="pwd">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-3">
                <label for="pwd">Retype Password:</label>
                <input type="password" name="repassword" class="form-control" id="pwd">
            </div>
        </div>
        <button type="submit" class="btn btn-default">Change</button>
    </form>
</div>
</body>
</html>

