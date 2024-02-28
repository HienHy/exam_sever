<%@ page import="com.example.exam_sever.entities.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<title>List</title>
<jsp:include page="/layout/css.jsp"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

<body>

<div class="container">
    <h1 class="text-center">ABC Company's Employee List</h1>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand btn btn-primary" href="create-employee">Create</a>
            <a class="navbar-brand btn btn-primary" href="list-employee">List</a>

        </div>
    </nav>


<jsp:include page="/layout/js.jsp"/>
</div>
</body>
</html>