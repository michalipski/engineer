<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <title>Place ${event.name}</title>
</head>
<body>
<div class="place">
  <table>
    <tr><th>${event.name}</th></tr>
    <tr><td>${place.name}</td></tr>
    <tr><td>${place.address}</td></tr>
  </table>
</div>
</body>
</html>
