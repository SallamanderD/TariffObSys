<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
    <title>TOS: Sign Up</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div class="container" style="padding-top: 5%;">
    <c:choose>
        <c:when test="${not empty error}">
            <ul>
                <c:forEach var="listValue" items="${error}">
                    <li>
                        <p class="alert-danger">${listValue}</p>
                    </li>
                </c:forEach>
            </ul>
        </c:when>
    </c:choose>
    <div class="regContainer">
        <h4 style="color: #1fa67b; text-align: center;">Registration</h4>
        <form method="POST" action="/register">
            <div>
                <div class="row">
                    <div class="form-group col-xs-6">
                        <label for="usr">Name:</label>
                        <input type="text" style="width: 105%; " value="${name}" name="name" class="form-control" id="usr">
                    </div>
                    <div class="form-group col-xs-6">
                        <label style="margin-left:-6%;" for="usr">Surname:</label>
                        <input type="text" style="width: 105%; margin-left: -6%;" value="${surname}" name="surname" class="form-control" id="usr">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-12">
                        <label for="usr">Email:</label>
                        <input type="text" value="${mail}" name="mail" class="form-control regInput" id="usr">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-12">
                        <label for="usr">Username:</label>
                        <input type="text" value="${username}" name="username" class="form-control regInput" id="usr">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-12">
                        <label for="pwd">Password:</label>
                        <input type="password" name="password" class="form-control regInput" id="pwd">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-12">
                        <label for="pwd">Confirm password:</label>
                        <input type="password" name="repassword" class="form-control regInput" id="pwd">
                    </div>
                </div>
                <div>
                    <input type="checkbox" name="cb1" id="cb1_1" value="1"/>
                    <label for="cb1_1" class="ui-widget">Are you agree with policy of our site?</label>
                </div>
                <div>
                    <button type="submit" class="btn btn-success">Sign Up</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

