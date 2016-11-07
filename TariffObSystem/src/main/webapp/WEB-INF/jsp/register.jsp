<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<jsp:include page="/mainmenu"></jsp:include>
<body>
<div class="container">
    <h2>Register</h2>
    <p>${error}</p>
    <form method="POST" action="/signup">
        <div class="form-group col-md-3">
        <label for="usr">Username:</label>
        <input type="text" name="username" class="form-control" id="usr">
    </div>
        <div class="form-group col-md-3">
            <label for="pwd">Password:</label>
            <input type="password" name="password" class="form-control" id="pwd">
        </div>
        <input type="submit"/>
    </form>
</div>
</body>
</html>

