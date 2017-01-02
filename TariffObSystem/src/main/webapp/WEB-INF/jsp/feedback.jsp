
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
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

<div class="mailbg">
    <label class="label2" for="feedback">Оставьте здесь ваш отзыв:</label>
    <textarea class="messtxt" name="text" style="width: 95%" id="feedback"
              rows="5" cols="77"></textarea>
    <button class="btn sendmess  " onclick="post('/feedback', {text: document.getElementById('feedback').value})" type="submit">Отправить</button>
</div>
<div class="container">
    <jsp:include page="/footer"></jsp:include>
</div>
</body>
</html>

