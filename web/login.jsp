<%--
  Created by IntelliJ IDEA.
  User: wLink
  Date: 3/22/2019
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<% String mess = "";
    if (request.getParameter("registered") != null && request.getParameter("registered").equals("true")) { mess = "Register successfully! Pls login.";}
%>
<h4><%= mess %></h4>
<h1>Login Form</h1>
<form method="post">
    <label for="name">Name:</label><br>
    <input id="name" type="text" name="name" placeholder="name"><br>
    <label for="pass">Password:</label><br>
    <input id="pass" type="password" name="pass" placeholder="pass"><br>
    <input type="submit" value="submit">
</form>

</body>
</html>
