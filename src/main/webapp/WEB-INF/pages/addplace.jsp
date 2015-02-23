<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Add place</title>
</head>
<body>
<div align="center">
  <form:form action="" method="POST" commandName="place">
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
        <td colspan="2" align="center"><input type="submit" value="Add place" /></td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>