<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Feedback" %><%--
  Created by IntelliJ IDEA.
  User: wLink
  Date: 3/18/2019
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
  <%
    ArrayList<Feedback> feedbackList;
    feedbackList = (ArrayList<Feedback>) request.getAttribute("feedback");
    
    if (feedbackList == null) {
      feedbackList = new ArrayList<Feedback>();
    }
  %>
  <div class="container mt-5">
    <h2>List feedback</h2>
    <p style="font-style: italic; color: grey">wo men bu yi yang...</p>
    <table class="table">
      <thead>
      <tr>
        <th>No.</th>
        <th>Username</th>
        <th>Feedback</th>
      </tr>
      </thead>
      <tbody>
      <% int i = 1; %>
      <% for (Feedback feedback : feedbackList) { %>
        <tr>
          <td><%= i %></td>
          <td><%= feedback.feedback %></td>
          <td><%= feedback.getUser().name %></td>
          <% i++; %>
        </tr>
      <% } %>
    </table>
  </div>
  </body>
</html>
