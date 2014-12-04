<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Registration Success</title>
</head>
<body>
<div align="center">
    <table border="0">
        <tr>
            <td colspan="2" align="center"><h2>Registration Succeeded!</h2></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <h3>Thank you for registering! Here's the review of your details:</h3>
            </td>
        </tr>
        <tr>
            <td>User Name:</td>
            <td>${userForm.username}</td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td>${userForm.email}</td>
        </tr>
        <tr>
            <td>Registration date</td>
            <td>${userForm.lastLoginDate}</td>
        </tr>

    </table>
</div>
</body>
</html>