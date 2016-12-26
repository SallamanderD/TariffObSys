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
                        <p> Если Вам необходимо выбрать нужный тариф, нажмите на пункт меню "Тарифы", расположенный на верхней панели.
                            С помощью фильтра вы сможете подобрать требующийся. Пользуясь нашим сервисом вы всегда будете вкурсе изменений тарифов и всегда сможете найти выгодный</p>
                        <br />
                        <a href="/tariffs" class="btn btn-block btn-success">К тарифам</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 text-center">
                <div class="titleBox">
                    <div class="box-content">
                        <h1 class="tag-title">Как выбрать тариф?</h1>
                        <hr />
                        <p> Хотите узнать что-то о владельце какого-то номера телефона? Воспользуйтесь нашим поиском вверху. Если не найдете ничего, не расстраивайтесь, может быть вы хотите рассказать нам о нем? Для этого вам понадобиться создать страницу номера телефона.
                        </p>
                        <br />
                        <a href="/createTelephone" class="btn btn-block btn-success">Создать</a>
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
                            и телефонных номеров.
                        </p>
                        <br />
                        <a href="/profile" class="btn btn-block btn-success">В личный кабинет</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>