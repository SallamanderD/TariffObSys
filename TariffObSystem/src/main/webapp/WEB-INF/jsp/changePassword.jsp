<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>TOS: Change Profile</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div class="regContainer" style="margin-top: 50px">
    <h3>Sign In</h3>
    <p>${error}</p>
    <form method="POST" action="/changePassword">
        <div class="row">
            <div class="form-group col-md-12">
                <label for="pwd">Old Password:</label>
                <input type="password" name="oldpassword" class="form-control regInput" id="pwd">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label for="pwd">Password:</label>
                <input type="password" name="password" class="form-control regInput" id="pwd">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label for="pwd">Retype Password:</label>
                <input type="password" name="repassword" class="form-control regInput" id="pwd">
            </div>
        </div>
        <button type="submit" style="display: block; margin-left: auto; margin-right: auto" class="btn buttonSnipp">
            Change</button>
    </form>
</div>
<div class="container">
    <jsp:include page="/footer"></jsp:include>
</div>
</body>
</html>

