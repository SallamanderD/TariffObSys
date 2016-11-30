<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
    <meta charset="utf-8">
    <title>TOS: ${user.username}</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
    <body>
    <div id="profileContainer" class="container ">
        <h2>Профиль</h2>
        <hr/>
        <div class="row">
            <div class="form-group col-md-3">
                <p class="lead">Логин: </p>
                <p class="lead">Имя: </p>
                <p class="lead">Фамилия: </p>
                <p class="lead">Эл. почта: </p>
            </div>
            <div class="form-group">
                <p class="lead"><mark>${user.username}</mark></p>
                <p class="lead"><mark>${user.name}</mark></p>
                <p class="lead"><mark>${user.surname}</mark></p>
                <p class="lead"><mark>${user.mail}</mark></p>
            </div>
        </div>
        <a href="changeUser"><button type="submit" class="btn btn-success">Change Data</button></a>
        <a href="changePassword"><button type="submit" class="btn btn-success">Change Password</button></a>
        <hr/>
    </div>
    </body>
</html>