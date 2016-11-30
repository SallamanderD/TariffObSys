<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
    <title>TOS: Sign In</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div class="container " style="padding-top: 5%;">
    <br>
    <c:if test="${not empty error}">
        <div class="msg msg-warning msg-danger-text">
            <span class="glyphicon glyphicon-exclamation-sign" style="padding-right: 5px;"></span>${error}</div>
    </c:if>
    <br>
    <div class="regContainer">
        <h4 style="text-align: center; color: #1fa67b; padding-bottom: 15px;">Log in with your email account</h4>
        <form method="POST" action="/signin">
            <div>
                <div class="row">
                    <div class="form-group col-xs-12">
                        <label for="usr">Username:</label>
                        <input type="text" name="username" class="form-control regInput" id="usr">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-12">
                        <label for="pwd">Password:</label>
                        <input type="password" name="password" class="form-control regInput" id="pwd">
                    </div>
                </div>
                <button type="submit" class="btn btn-block btn-success" style="margin-top: 5px; margin-bottom: 10px;">Sign In</button>
                <a href= "" class="forget" style="margin-bottom: 10px;" data-toggle="modal" data-target=".forget-modal">
                    Forgot your password?</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>

