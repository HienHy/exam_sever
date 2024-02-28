
<%@ page import="com.example.exam_sever.entities.Employee" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: hiennd
  Date: 25/01/2024
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <jsp:include page="/layout/css.jsp"/>

</head>
<body>
<div class="col-6">

    <% Employee employee = (Employee) request.getAttribute("employee");%>

    <form method="post" action="edit-employee?id=<%= employee.getId() %>">

        <div class="mb-3">
            <label for="exampleInputName1" class="form-label">Name</label>
            <input value="<%= employee.getName() %>" name="name" type="text" class="form-control" id="exampleInputName1" required>
        </div>

        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input name="email" value="<%= employee.getEmail() %>" type="email" class="form-control"
                   id="exampleInputEmail1"
                   aria-describedby="emailHelp"
                   required>

        </div>
        <div class="mb-3">
            <label for="exampleInputAddress1" class="form-label">Phone</label>
            <input name="phone" value="<%= employee.getPhone() %>" type="text" class="form-control"
                   id="exampleInputAddress1">
        </div>
        <div class="mb-3">
            <label for="exampleInputAddress2" class="form-label">Birthday</label>
            <input name="birthday" value=" <%= new SimpleDateFormat("yyyy-MM-dd").format(employee.getBirthday()) %>" type="date" class="form-control"
                   id="exampleInputAddress2">
        </div>


        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
