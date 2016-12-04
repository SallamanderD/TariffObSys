<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2><b>Комментарии [${count}]: </b></h2>
<div class="col-md-12">
    <c:if test="${not empty userId}">
        <div>
            <form method="post" action="/addTelephoneCommentary">
                <label for="comment">Комментарий:</label>
                <textarea class="form-control" name="text" style="min-width: 100%" placeholder="Ваш комментарий" id="comment"
                          rows="5" cols="77"></textarea>
                <input type="hidden" value="${telephoneId}" name="telephoneId"/>
                <button class="btn mysearch btn-success" style="margin-top: 1%" type="submit">Отправить</button>
            </form>
            <hr id="lineHr">
        </div>
    </c:if>
    <c:forEach var="comment" items="${commentaries}">
        <div class="bs-calltoaction bs-calltoaction-success">
            <div class="row">
                <div class="col-md-12 cta-contents">
                    <h4 class="cta-title">${comment.author.username}</h4>
                    <div class="cta-desc">
                        <p>${comment.date}</p>
                        <div class="commentsText">
                            <p style="color:black">${comment.text}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>