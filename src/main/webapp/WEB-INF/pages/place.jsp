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
                <tr>${place.name}</tr>
                <tr>${place.address}</tr>
            </table>
        </div>
        <div class="comments">
            <table>
                <c:forEach items="${place.comments}" var="comment">
                    <tr><td>${comment.date}</td><td>${comment.description}</td></tr>
                </c:forEach>
            </table>
        </div>
</body>
</html>
