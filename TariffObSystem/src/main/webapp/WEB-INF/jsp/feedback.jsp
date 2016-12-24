
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
<div class="container content">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="testimonials">
                <div class="active item">
                    <blockquote>
                        <label for="comment">Оставьте здесь ваш отзыв:</label>
                        <textarea class="form-control" name="text" style="width: 95%" id="comment"
                                  rows="5" cols="77"></textarea>
                        <button class="btn mysearch btn-success" style="margin-top: 1%" type="submit">Отправить</button>
                    </blockquote>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

