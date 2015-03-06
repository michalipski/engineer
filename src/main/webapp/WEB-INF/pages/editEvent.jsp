<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Edit event</title>
</head>
<body>
<c:url value="" var="editLink"/>
<form:form action="${editLink}" method="POST" commandName="editedEvent">
  <table border="0">
    <tr>
      <td colspan="2" align="center"><h2></h2></td>
    </tr>
    <tr>
      <td>Event Name:</td>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
      <td>Event date:</td>
      <td><form:input path="data" /></td>
    </tr>
    <tr>
      <td>Place Name:</td>
      <td><form:select itemLabel="label" itemValue="id" path="place.id" commandName="placeId" items="${placesList}"/></td>
    </tr>
    <tr>
      <td>Place description:</td>
      <td><form:input path="description" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><input type="submit" value="Edit event" /></td>
    </tr>
  </table>
</form:form>
</body>
</html>
