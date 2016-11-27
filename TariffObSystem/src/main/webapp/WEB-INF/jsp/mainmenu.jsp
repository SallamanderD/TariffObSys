<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Francois+One" rel="stylesheet"> <!--Fonts for navbar-->
    <link href="https://fonts.googleapis.com/css?family=Oxygen" rel="stylesheet">       <!--Fonts for navbar-->
    <link href="css/style.css" rel="stylesheet">
</head>
    <body>
    <nav class="navbar navbar-default navbar-custom">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">Tariff Observer System</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/tariffs">Tariffs</a></li>
                    <li>
                        <form class="navbar-form" role="search">
                            <div class="input-group" >
                                <input type="text" class="form-control" placeholder="Telephone" name="q">
                                <div class="input-group-btn">
                                    <button class="btn mysearch btn-success" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                                </div>
                            </div>
                        </form>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:choose>
                        <c:when test="${empty user}">
                            <li><a href="/signin">Sign In</a></li>
                            <li><a href="/register">Sign Up</a></li>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${not empty user.activated}">
                                    <a href="/activate" class="btn mysearch btn-success navbar-btn">Confirm Email</a>
                                </c:when>
                            </c:choose>
                            <li><a href="profile">${user.username}</a></li>
                            <li><a href="/logout">Logout</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
    </body>

</body>
</html>