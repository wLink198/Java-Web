<%@ page import="java.util.HashMap" %>
<%@ page import="entity.Phone" %><%--
  Created by IntelliJ IDEA.
  User: wLink
  Date: 6/14/2019
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>Add Phone</title>
</head>
<body>
<%--<%--%>
    <%--HashMap<String, String> errors;--%>
    <%--errors = (HashMap<String, String>) request.getAttribute("errors");--%>

    <%--if (errors == null) {--%>
        <%--errors = new HashMap<String, String>();--%>
    <%--}--%>

    <%--Phone phone;--%>
    <%--phone = (Phone) request.getAttribute("phone");--%>

    <%--if (phone == null) {--%>
        <%--phone = new Phone();--%>
    <%--}--%>

    <%--int userId = 0;--%>
    <%--Cookie[] cookies = request.getCookies();--%>
    <%--for (Cookie cookie : cookies) {--%>
        <%--if (cookie.getName().equals("userId")) {--%>
            <%--userId = Integer.valueOf(cookie.getValue());--%>
        <%--}--%>
    <%--}--%>
<%--%>--%>
<div class="container">
    <h3 class="mb-3 mt-5">Add Phone</h3>
    <form method="post">
        <div class="form-group">
            <label for="name">Name</label>
            <input name="name" type="text" class="form-control" id="name" placeholder="Enter name" required>
        </div>

        <div class="form-group">
            <label for="brand">Brand</label>
            <select id="brand" name="brand" class="custom-select" required>
                <option disabled selected>___Select___</option>
                <option value="Apple">Apple</option>
                <option value="Samsung">Samsung</option>
                <option value="Nokia">Nokia</option>
                <option value="Others">Others</option>
            </select>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <input name="price" type="number" class="form-control" id="price" placeholder="Enter price" required min="1">
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <input name="description" type="text" class="form-control" id="description" placeholder="Enter description" required>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-primary">Reset</button>
    </form>
</div>
</body>
</html>
