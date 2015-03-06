<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <title>Places list</title>
    <c:url value="/filterplaceslist" var="filterUrl"/>
</head>
<body>
<div class="filterform">
    <form:form action="${filterUrl}" method="POST" commandName="filterRequest">
        <table border="0">
            <tr><td>Nazwa: <form:input path="name"/></td><td>Miasto: <form:input path="city"/></td><td><input type="submit" value="Filtruj"/></td></tr></table>
    </form:form>

</div>
<div class="list">
  <table border="0">
  <c:forEach items="${places}" var="place">
      <tr onclick="window.location.href = '<c:url value="place/${place.id}"/>'">
          <td>${place.name}</td><td>${place.city}</td><td>${place.address}</td><td>${place.phone}</td>
          <sec:authorize access="hasRole('ROLE_ADMIN')">
              <td><a href="<c:url value="/place/edit/${place.id}"/>">Edytuj</a></td><td><a href="<c:url value="/place/delete/${place.id}"/>">Usun</a></td>
          </sec:authorize>
      </tr>
  </c:forEach>
  </table>
</div>
</body>
</html>
