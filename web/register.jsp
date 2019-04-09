<%@ page import="java.util.HashMap" %>
<%@ page import="entity.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: wLink
  Date: 4/1/2019
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<%
    HashMap<String, ArrayList<String>> errors;
    errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");

    if (errors == null) {
        errors = new HashMap<String, ArrayList<String>>();
    }

    User user;
    user = (User) request.getAttribute("user");

    if (user == null) {
        user = new User();
    }
%>
<%
    if (errors.containsKey("name")) {
        ArrayList<String> nameErrors = errors.get("name");
        for (String error:
             nameErrors) {
            %>
            <span><%=error%></span><br>
            <%
        }
    }

    if (errors.containsKey("pass")) {
        ArrayList<String> passErrors = errors.get("pass");
        for (String error:
                passErrors) {
            %>
            <span><%=error%></span><br>
            <%
        }
    }
%>
<form method="post">
    <p>Name:</p>
    <input type="text" name="name" value="<%= user.name!=null?user.name:"" %>"/>
    <%--<% if (errors.containsKey("name")) { %>--%>
    <%--<span><%= errors.get("name") %></span>--%>
    <%--<% } %>--%>
    <br/>
    <p>Pass:</p>
    <input type="password" name="password"/>
    <%--<% if (errors.containsKey("pass")) { %>--%>
    <%--<span><%= errors.get("pass") %></span>--%>
    <%--<% } %>--%>
    <br/><br/><br/>
    <input type="submit"/>
</form>
</body>
</html>
