<%@ page import="java.util.List" %>
<%@ page import="com.example.exam_sever.entities.Employee" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <jsp:include page="/layout/css.jsp"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">


</head>

<body>

<div class="container">

    <h1 class="text-center">ABC Company's Employee List</h1>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand btn btn-primary" href="create-employee">Create</a>
            <a class="navbar-brand btn btn-primary" href="list-employee">List</a>

        </div>
    </nav>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">

                <form class="d-flex">
                    <input class="form-control me-2" type="search" name="search" value="<%= request.getAttribute("search")!= null ? request.getAttribute("search"):""%>" placeholder="Search by name" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>

    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Birthday</th>
                <th scope="col">Phone</th>
                <th scope="col">Email</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>

            <%
                for (Employee s : (List<Employee>) request.getAttribute("employees")
                )

                { %>

            <tr>
                <td><%= s.getId() %>
                </td>
                <td><%= s.getName() %>
                </td>
                <td><%= s.getBirthday() %>
                </td>
                <td><%= s.getPhone() %>
                <td><%= s.getEmail() %>
                </td>
                <td><a href="edit-employee?id=<%= s.getId()%>">Edit</a>
                </td>

                <td><a class="text-danger" onclick="deleteEmployee(<%= s.getId() %>)"
                       href="javascript:void(0);">Delete</a></td>

            </tr>


            <% } %>

            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">
    function deleteEmployee(id) {
        if (confirm("Are you sure?")) {
            var url = `list-employee?id=` + id;
            fetch(url, {
                method: 'DELETE'
                // body: formData
            }).then(rs => {
                if (confirm("Delete successfully! Reload page?"))
                    window.location.reload();
            }).error(err => {
                alert(err)
            })
        }
    }



</script>
<jsp:include page="/layout/js.jsp"/>

</body>
</html>
