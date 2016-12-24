<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
        <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="css/style.css" rel="stylesheet">
        <title>Tariff Observer System</title>
    </head>
    <div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
    </div>
    <body>
    <div class="container">
        <div class="col-md-4 text-center">
            <div class="box">
                <div class="box-content">
                    <h1 class="tag-title">Домашняя страница</h1>
                    <hr />
                    <p> С помощью нашего сайта, вы сможете найти информацию об интересующем вас мобильном тарифе,
                        найти подходящий вам тариф или просмотреть список телефонных номеров пользователей.
                        Для того, чтобы вам был доступен вес функционал сайта, необходимо зарегистрироваться в системе. </p>
                    <br />
                    <a href="ppc.html" class="btn btn-block btn-success">Learn more</a>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>