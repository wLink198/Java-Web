<%@ page import="entity.Feedback" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: wLink
  Date: 4/9/2019
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feedback</title>
</head>
<body>
<%
    HashMap<String, String> errors;
    errors = (HashMap<String, String>) request.getAttribute("errors");

    if (errors == null) {
        errors = new HashMap<String, String>();
    }

    Feedback fb;
    fb = (Feedback) request.getAttribute("fb");

    if (fb == null) {
        fb = new Feedback();
    }

    int userId = 0;
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("userId")) {
            userId = Integer.valueOf(cookie.getValue());
        }
    }
%>
<form method="post">
    <p>Feedback:</p>
    <input type="text" name="feedback" value="<%= fb.feedback!=null?fb.feedback:"" %>"/>
    <% if (errors.containsKey("feedback")) { %>
    <span><%= errors.get("feedback") %></span>
    <% } %>
    <br/>
    <input hidden type="text" name="userId" value="<%= userId %>">
    <input type="submit"/>
</form>
</body>
</html>
