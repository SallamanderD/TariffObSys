<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2><b>Commentaries: </b></h2>
<div class="col-md-12">
    <c:if test="${not empty userId}">
        <div>
            <form method="post" action="/addTelephoneCommentary">
                <label for="comment">Comment:</label>
                <textarea class="form-control" name="text" style="min-width: 100%" placeholder="Enter your commentary" id="comment"
                          rows="5" cols="77"></textarea>
                <input type="hidden" value="${telephoneId}" name="telephoneId"/>
                <button class="btn mysearch btn-success" style="margin-top: 1%" type="submit">Send</button>
            </form>
        </div>
    </c:if>
    <ul class="list-group">
        <c:forEach var="comment" items="${commentaries}">
            <li class="list-group-item">
                <div class="" style="background-color: white">
                    <p>${comment.author.username}</p>
                    <p>${comment.date}</p>
                    <p class="text">${comment.text}</p>
                </div>
            </li>
            <hr/>
        </c:forEach>
    </ul>
</div>
</div>
</body>
</html>