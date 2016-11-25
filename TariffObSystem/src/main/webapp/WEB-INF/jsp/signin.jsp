<!DOCTYPE html>
<html lang="en">
<head>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <title>TOS: Sign In</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div class="container">
    <h3>Sign In</h3>
    <p>${error}</p>
    <div id="outer">
    <form method="POST" action="/signin">
        <div id="inner">
            <div class="row">
                <div class="form-group col-md-3">
                    <label for="usr">Username:</label>
                    <input type="text" name="username" class="form-control" id="usr">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-3">
                    <label for="pwd">Password:</label>
                    <input type="password" name="password" class="form-control" id="pwd">
                </div>
            </div>
                    <button type="submit" class="btn btn-success">Sign In</button>
        </div>
    </form>
    </div>
</div>
</body>
</html>

