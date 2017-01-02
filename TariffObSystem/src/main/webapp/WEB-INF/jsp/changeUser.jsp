<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>TOS: Change Profile</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div class="container regContainer">
    <h3>Sign In</h3>
    <p>${error}</p>
    <form method="POST" action="/changeUser">
        <div class="row">
            <div class="form-group col-md-12">
                <label for="usr">Username:</label>
                <input type="text" name="username" value="${user.username}" class="form-control regInput" id="usr">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label for="usr">Name:</label>
                <input type="text" name="name" value="${user.name}"class="form-control regInput" id="usr">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label for="usr">Surname:</label>
                <input type="text" name="surname" class="form-control regInput" value="${user.surname}" id="usr">
            </div>
        </div>
        <button type="submit" style="display: block; margin-left: auto; margin-right: auto" class="btn buttonSnipp">Change</button>
    </form>
</div>
<div class="container">
    <jsp:include page="/footer"></jsp:include>
</div>
</body>
</html>

