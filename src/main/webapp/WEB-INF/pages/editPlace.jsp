<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit place</title>
</head>
<body>
<c:url value="" var="editLink"/>
<form:form action="${editLink}" method="POST" commandName="editedPlace">
  <table border="0">
    <tr>
      <td colspan="2" align="center"><h2></h2></td>
    </tr>
    <tr>
      <td>Place Name:</td>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
      <td>Place address:</td>
      <td><form:input path="address" /></td>
    </tr>
    <tr>
      <td>Place city:</td>
      <td><form:input path="city" /></td>
    </tr>
    <tr>
      <td>Place openhour:</td>
      <td><form:input path="openHour" /></td>
    </tr>
    <tr>
      <td>Place closehour:</td>
      <td><form:input path="closeHour" /></td>
    </tr>
    <tr>
      <td>Place phone:</td>
      <td><form:input path="phone" /></td>
    </tr>
    <tr>
      <td>Place description:</td>
      <td><form:input path="description" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><input type="submit" value="Edit place" /></td>
    </tr>
  </table>
</form:form>
</body>
</html>
