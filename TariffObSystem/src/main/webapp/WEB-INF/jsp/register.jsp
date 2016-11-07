<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <title>TOS: Sign Up</title>
</head>
<jsp:include page="/mainmenu"></jsp:include>
<body>
<div class="container">
    <h2>Register</h2>
    <p class="alert-danger">${error}</p>
    <form method="POST" action="/register">
        <div>
            <div class="row">
                <div class="form-group col-md-3">
                    <label for="usr">Name:</label>
                    <input type="text" name="name" class="form-control" id="usr">
                </div>
                <div class="form-group col-md-3">
                    <label for="usr">Surname:</label>
                    <input type="text" name="surname" class="form-control" id="usr">
                </div>
            </div>
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
        </div>
        <button type="submit" class="btn btn-default">Sign In</button>
    </form>
</div>
</body>
</html>

