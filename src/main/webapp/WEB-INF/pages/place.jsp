<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Place ${place.name}</title>
</head>
<body>
        <div class="place">
            <table>
                <tr><td>${place.name}</td></tr>
                <tr><td>${place.address}</td></tr>
            </table>
        </div>
        <br/>
        <c:choose>
            <c:when test="${grade==0}">
                <div class="gradePlace">
                    <form action="<c:url value="/place/grade/${place.id}"/>" method="post">
                        <input type="submit" value="1" name="grade"/>
                        <input type="submit" value="2" name="grade"/>
                        <input type="submit" value="3" name="grade"/>
                        <input type="submit" value="4" name="grade"/>
                        <input type="submit" value="5" name="grade"/>
                    </form>
                </div>
            </c:when>
            <c:otherwise>
                Twoja ocena to: ${grade}
            </c:otherwise>
        </c:choose>

        <br/>
        <div class="addComment">
            <form action="<c:url value="/place/comment/${place.id}"/>" method="post">
                Dodaj komentarz<br/>
                <input type="text" name="comment"/>
                <input type="submit" value="Dodaj komentarz"/>
            </form>
        </div>
        <div class="comments">
            Komentarze
            <table>
                <c:forEach items="${place.comments}" var="comment">
                    <tr><td>${comment.date}</td><td>${comment.description}</td></tr>
                </c:forEach>
            </table>
        </div>
</body>
</html>
