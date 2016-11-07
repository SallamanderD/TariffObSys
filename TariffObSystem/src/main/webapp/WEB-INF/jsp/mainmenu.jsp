<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>

    </head>
    <body>
        <div>
            <ul style="margin-top: 20px;">
                <li style="display: inline; margin-right: 20px"><a href="/">Home</a></li>
                <li style="display: inline; margin-right: 20px;"><a href="tariffs">Tariffs</a></li>
                <c:choose>
                    <c:when test="${empty user}">
                        <li style="display: inline; margin-right: 20px;"><a href="signin">Sign In</a></li>
                        <li style="display: inline; margin-right: 20px;"><a href="register">Sign Up</a></li>
                    </c:when>
                    <c:otherwise>
                        <li style="display: inline; margin-right: 20px;"><a href="user">${user.username}</a></li>
                        <li style="display: inline; margin-right: 20px;"><a href="/logout">Logout</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </body>
</html>