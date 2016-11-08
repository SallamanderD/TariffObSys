<!DOCTYPE html>
<html lang="en">
<head>
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <title>TOS: Sign In</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div class="container">
    <h3>Sign In</h3>
    <p>${error}</p>
    <form method="POST" action="/signin">
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
        <button type="submit" class="btn btn-default">Sign In</button>
    </form>
</div>
</body>
</html>

