<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <meta charset="utf-8">
    <title>TOS: Confirm Mail</title>
</head>
<div class="container">
    <jsp:include page="/mainmenu"></jsp:include>
</div>
<body>

<div class="container">
    <h2>We sent code on your email. Pls, enter it this. <a target="_blank" href="${mail}"> Go To Email</a></h2>

    <form method="POST" action="/activate">
    <div class="row">
        <div class="form-group col-md-3">
            <label for="code">Your code:</label>
            <input type="text" name="code" class="form-control" id="code">
        </div>

    </div>
        <button type="submit" class="btn btn-default">Activate</button>
    </form>
</div>
</body>
</html>