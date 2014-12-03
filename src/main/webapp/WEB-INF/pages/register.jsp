<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
    <h2>${msg}</h2><br/>
    <form action="<c:url value="/register"/>" method="post">
        Username:<input type="text" name="username" /><br/>
        Password:<input type="password" name="password" /><br/>
        E-mail<input type="email" name="email" /><br/>
        <input type="submit" name="submit" value="Sign up!" />
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
</body>
</html>
