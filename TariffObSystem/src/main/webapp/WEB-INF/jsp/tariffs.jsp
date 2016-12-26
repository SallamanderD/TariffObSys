<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <link href="css/style.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <title>TOS: Tariffs</title>
</head>
<script>
    $(document).on('click', '.panel div.clickable', function (e) {
        var $this = $(this); //Heading
        var $panel = $this.parent('.panel');
        var $panel_body = $panel.children('.panel-body');
        var $display = $panel_body.css('display');

        if ($display == 'block') {
            $panel_body.slideUp();
        } else if($display == 'none') {
            $panel_body.slideDown();
        }
    });

    $(document).ready(function(e){
        var $classy = '.panel.autocollapse';

        var $found = $($classy);
        $found.find('.panel-body').hide();
        $found.removeClass($classy);
    });
</script>

<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
<div class="container" style="margin-top: 4%; max-width: 74%">
    <div class="row">
            <section class="content">
            <div class="col-sm-12 viewTarContainer">
                <div class="col-sm-8 col-sm-offset-4">
                    <h3><b>Доступные тарифы:</b></h3>
                </div>
                <div class="panel col-sm-4 autocollapse mypanel">
                    <div class="panel-heading clickable ">
                        <h3 class="panel-title">Фильтр</h3>
                    </div>
                    <div class="panel-body">
                        <form action="filter", method="post">
                            <div>
                                <div>
                                    <h4>3G</h4>
                                    <div class="form-inline">
                                        От: <input type="number" name="GLow" class="form-control withoutSpinners" style="max-width: 30%">
                                        До: <input type="number" name="GHigh" class="form-control" style="max-width: 30%">
                                    </div>
                                </div>
                                <div>
                                    <h4>Звонки в сети, минут</h4>
                                    <div class="form-inline">
                                        От: <input type="number" name = "incallsLow" class="form-control" style="max-width: 30%"/>
                                        До: <input type="number" name = "incallsHigh" class="form-control" style="max-width: 30%"/>
                                    </div>
                                </div>
                                <div>
                                    <h4>Звонки на других операторов, минут</h4>
                                    <div class="form-inline">
                                        От: <input type="number" name = "outcallsLow" class="form-control" style="max-width: 30%"/>
                                        До: <input type="number" name = "outcallsHigh" class="form-control" style="max-width: 30%"/>
                                    </div>
                                </div>
                                <div>
                                    <h4>Соц. сети</h4>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="vk" value="true">VK</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="fb" value="true">Facebook</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="ok" value="true">OK</label>
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="tw" value="true">Twitter</label>
                                    </div>
                                </div>
                                <div>
                                    <h4>СМС</h4>
                                    <div class="form-inline">
                                        От: <input type="number" name = "smsLow" class="form-control" style="max-width: 30%"/>
                                        До: <input type="number" name = "smsHigh" class="form-control" style="max-width: 30%"/>
                                    </div>
                            </div>
                                <div>
                                    <input type="submit" class="btn btn-success" value="Применить" style="margin-top: 15px;">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-sm-8">
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
                                                            <span class="media-meta pull-right">${listValue.time}</span>
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
            </div>
        </section>
    </div>
</div>
</body>
</html>