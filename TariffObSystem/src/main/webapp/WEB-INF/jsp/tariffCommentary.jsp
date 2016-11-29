<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2><b>Commentaries [${commentaries.size()}]: </b></h2>
<div class="col-md-12">
        <c:if test="${not empty userId}">
        <div>
            <form method="post" action="/addTariffCommentary">
                <label for="comment">Comment:</label>
                <textarea class="form-control" name="text" style="min-width: 100%" placeholder="Enter your commentary" id="comment"
                          rows="5" cols="77"></textarea>
                <input type="hidden" value="${commentaries.get(0).tariffId}" name="tariffId"/>
                <button class="btn mysearch btn-success" style="margin-top: 1%" type="submit">Send</button>
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