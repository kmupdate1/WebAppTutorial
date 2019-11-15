<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 2019/11/13
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Welcome, please login:</h1>
    <form action="/login" method="post">
        login name: <input type="text" name="login_name" width="50"/><br>
        password: <input type="password" name="password" width="50"/>
        <input type="submit" value="login"/>
    </form>
</body>
</html>
