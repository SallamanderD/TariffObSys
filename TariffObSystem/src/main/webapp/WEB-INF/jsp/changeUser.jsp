<!DOCTYPE html>
<html lang="en">
<head>
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <title>TOS: Change Profile</title>
</head>
<jsp:include page="/mainmenu"></jsp:include>
<body>
<div class="container">
    <h3>Sign In</h3>
    <p>${error}</p>
    <form method="POST" action="/changeUser">
        <div class="row">
            <div class="form-group col-md-3">
                <label for="usr">Username:</label>
                <input type="text" name="username" value="${user.username}" class="form-control" id="usr">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-3">
                <label for="usr">Name:</label>
                <input type="text" name="name" value="${user.name}"class="form-control" id="usr">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-3">
                <label for="usr">Surname:</label>
                <input type="text" name="surname" class="form-control" value="${user.surname}" id="usr">
            </div>
        </div>
        <button type="submit" class="btn btn-default">Change</button>
    </form>
</div>
</body>
</html>

