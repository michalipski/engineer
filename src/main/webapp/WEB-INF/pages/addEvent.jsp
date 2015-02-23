<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Add event</title>
</head>
<body>
<div align="center">
  <form:form action="" method="POST" commandName="event">
    <table border="0">
      <tr>
        <td colspan="2" align="center"><h2></h2></td>
      </tr>
      <tr>
        <td>Place Name:</td>
        <td><form:input path="name" /></td>
      </tr>
      <tr>
        <td>Place description:</td>
        <td><form:input path="description" /></td>
      </tr>
      <tr>
        <td>Event date:</td>
        <td><form:input path="data" /></td>
      </tr>
      <tr>
        <td>Event place:</td>
        <td><form:select path="places" items="${placesList}"/></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" value="Add event" /></td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>