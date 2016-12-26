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
        <div class="row">
            <div class="col-md-4 text-center">
                <div class="titleBox">
                    <div class="box-content">
                        <h1 class="tag-title">Это домашняя страница</h1>
                        <hr />
                        <p> Tariff observer system - система, предоставляющая информацию о мобильных тарифах Украины.
                            С помощью нашего сайта, Вы сможете найти информацию об интересующих вас тарифах,
                            выбрать наиболее подходящий из них или просмотреть список телефонных номеров пользователей.</p>
                        <br />
                        <a href="ppc.html" class="btn btn-block btn-success">Узнать подробности</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 text-center">
                <div class="titleBox">
                    <div class="box-content">
                        <h1 class="tag-title">Как выбрать тариф?</h1>
                        <hr />
                        <p> Если Вам необходимо выбрать нужный тариф, нажмите на пункт меню "Тарифы", расположенный на верхней панели.
                            С помощью фильтра вы сможете подобрать требующийся. Хотите найти информацию о владельце телефонного номера?
                            Воспользуйтесь поиском по телефонным номерам.
                        </p>
                        <br />
                        <a href="ppc.html" class="btn btn-block btn-success">Learn more</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 text-center">
                <div class="titleBox">
                    <div class="box-content">
                        <h1 class="tag-title">Личный кабинет</h1>
                        <hr />
                        <p>Для того, чтобы Вам был доступен весь функционал сайта, необходимо зарегистрироваться в системе.
                            Для Вас будет создан личный кабинет, в котором также представлена статистика активности на сайте.
                            После этого Вы сможете добавлять номера телефонов, вести обсуждение представленных тарифов
                            и телефонных номеров, а также оставлять отзывы о нашем сайте.
                        </p>
                        <br />
                        <a href="ppc.html" class="btn btn-block btn-success">Learn more</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>