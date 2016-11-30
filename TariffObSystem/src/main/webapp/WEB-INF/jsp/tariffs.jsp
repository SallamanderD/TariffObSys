<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <link href="css/style.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <title>TOS: Tariffs</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div class="container" style="margin-top: 4%">
    <div class="row">
        <section class="content">
            <div class="col-md-8 col-md-offset-2">
                <h3><b>Фильтр: </b></h3>
                <form action="filter" , method="post">
                    <div class="panel panel-default">
                        <div>
                            <h4>3G</h4>
                            <div class="form-inline">
                                <p>От: <input type="number" class="form-control" style="max-width: 10%"/>
                                    До: <input type="number" class="form-control" style="max-width: 10%"/></p>                                                                                              class="form-control"/>
                            </div>
                        </div>
                        <div>
                            <h4>Звонки в сети, минут</h4>
                            <div class="form-inline">
                                <p>От: <input type="number" class="form-control" style="max-width: 10%"/>
                                    До: <input type="number" class="form-control" style="max-width: 10%"/></p>                                                                                              class="form-control"/>
                            </div>
                        </div>
                        <div>
                            <h4>Звонки на других операторов, минут</h4>
                            <div class="form-inline">
                                От: <input type="number" class="form-control" style="max-width: 10%"/>
                                    До: <input type="number" class="form-control" style="max-width: 10%"/>                                                                                             class="form-control"/>
                            </div>
                        </div>
                        <div>
                            <h4>Соц. сети</h4>
                            <div class="checkbox">
                                <label><input type="checkbox" value="">VK</label>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" value="">Facebook</label>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" value="">OK</label>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" value="">Twitter</label>
                            </div>
                        </div>
                        <div>
                            <h4>СМС</h4>
                            <div class="form-inline">
                                <p>От: <input type="number" class="form-control" style="max-width: 10%"/>
                                    До: <input type="number" class="form-control" style="max-width: 10%"/></p>                                                                                              class="form-control"/>
                            </div>
                        </div>
                        <input type="submit" class="btn btn-success">
                    </div>
                </form>
                <h3><b>Доступные тарифы:</b></h3>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="table-container">
                            <table class="table table-filter">
                                <tbody>
                                <c:choose>
                                    <c:when test="${not empty tariffs}">
                                        <c:forEach var="listValue" items="${tariffs}" varStatus="loop">
                                            <tr onclick="post('/tariff/${listValue.id}')">
                                                <td>
                                                    <div class="media">
                                                        <div class="media-body">
                                                            <span class="media-meta pull-right">February 13, 2016</span>
                                                            <h4 class="title">
                                                                <img src="/ico/${listValue.operator.name}.png"
                                                                     height="18" width="18"/> ${listValue.name}
                                                                <span class="pull-right vodafone"><a
                                                                        href="/operator/${listValue.operator.name}">${listValue.operator.name}</a></span>
                                                            </h4>
                                                            <p class="summary">${listValue.shortDescription}</p>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        Oops! Empty list.
                                    </c:otherwise>
                                </c:choose>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
</body>
</html>