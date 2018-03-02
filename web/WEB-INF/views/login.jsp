<%--
  Created by IntelliJ IDEA.
  User: maier
  Date: 02.03.2018
  Time: 08:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login-Page</h1>

<h2>${error}</h2>
<form action="/einloggen.do" method="post">
    Loginname: <input type="text" name="loginname">
    Passwort: <input type="password" name="password">
    <input type="submit" value="Einloggen"/>
</form>

</body>
</html>
