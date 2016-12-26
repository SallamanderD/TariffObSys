<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>

<body>
<h2><b>Комментарии [${count}]: </b></h2>
<div class="col-md-12">
    <c:if test="${not empty userId}">
        <div>
            <form method="post" action="/addTariffCommentary">
                <label for="comment">Комментарий:</label>
                <textarea class="form-control" name="text" style="min-width: 100%" placeholder="Ваш комментарий" id="comment"
                          rows="5" cols="77"></textarea>
                <input type="hidden" value="${tariffId}" name="tariffId"/>
                <button class="btn mysearch btn-success" style="margin-top: 1%" type="submit">Отправить</button>
            </form>
            <hr id="lineHr">
        </div>
    </c:if>
    <c:forEach var="comment" items="${commentaries}" varStatus="loop">
        <div class="bs-calltoaction bs-calltoaction-success">
            <div class="row">
                <div class="col-md-12 cta-contents" onmouseleave="document.getElementById('delete${loop.index}').style.opacity = '0'" onmouseenter="
                        var a = ${comment.author.id};
                        var b = ${userId};
                        if(a == b){
                        document.getElementById('delete${loop.index}').style.opacity = '1';
                        }
                        ">
                    <h4 class="cta-title">${comment.author.username}</h4>
                    <div class="cta-desc">
                        <p>${comment.date}</p>
                        <div class="commentsText">
                            <p style="color:black">${comment.text}</p>
                        </div>
                        <div>
                            <div class="con" onclick="post('/deleteTariffCommentary', {id: ${comment.id}, authorId: ${userId}, tariffId: ${tariffId}})"
                                 id="delete${loop.index}" style="opacity: 0;">
                                <div>
                                    <div class="col-md-6" style="margin-left: -10px; padding-top: 5%">
                                        <h4>Удалить?</h4>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="bar top"></div>
                                        <div class="bar middle"></div>
                                        <div class="bar bottom"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>