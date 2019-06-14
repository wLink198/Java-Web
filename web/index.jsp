<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Feedback" %>
<%@ page import="entity.Phone" %><%--
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
    ArrayList<Phone> phoneList;
    phoneList = (ArrayList<Phone>) request.getAttribute("phoneList");
    
    if (phoneList == null) {
      phoneList = new ArrayList<Phone>();
    }
  %>
  <div class="container mt-5">
    <h2 class="mb-3">List feedback</h2>
    <table class="table">
      <thead>
      <tr>
        <th>No.</th>
        <th>Name</th>
        <th>Brand</th>
        <th>Price</th>
        <th>Description</th>
      </tr>
      </thead>
      <tbody>
      <% int i = 1; %>
      <% for (Phone phone : phoneList) { %>
        <tr>
          <td><%= i %></td>
          <td><%= phone.getName() %></td>
          <td><%= phone.getBrand() %></td>
          <td><%= phone.getPrice() %></td>
          <td><%= phone.getDescription() %></td>
          <% i++; %>
        </tr>
      <% } %>
    </table>
  </div>
  </body>
</html>
