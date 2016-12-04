<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>TOS: Confirm Mail</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>
${error}
<div class="container">
    <h2>Мы отправили вам код на эл. почту, пожалуйста, введите его тут. <a target="_blank" href="${mail}">К эл. почте</a></h2>
    <form method="POST" action="/activate">
    <div class="row">
        <div class="form-group col-md-3">
            <label for="code">Ваш код:</label>
            <input type="text" name="code" class="form-control" id="code">
        </div>
    </div>
        <button type="submit" class="btn btn-default">Активировать</button>
    </form>
</div>
</body>
</html>