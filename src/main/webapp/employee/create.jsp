<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <jsp:include page="/layout/css.jsp"/>

</head>
<body>

<div class="container">
    <h1>Add New Employee</h1>
    <div class="col-6">


        <form method="post" action="create-employee">
            <div class="mb-3">
                <label for="exampleInputName1" class="form-label">Name</label>
                <input name="name" type="text" class="form-control" id="exampleInputName1" required>
            </div>

            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email address</label>
                <input name="email" type="email" class="form-control" id="exampleInputEmail1"
                       aria-describedby="emailHelp"
                       required>
                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
            </div>
            <div class="mb-3">
                <label for="exampleInputAddress1" class="form-label">Phone</label>
                <input name="phone" type="text" class="form-control" id="exampleInputAddress1">
            </div>

            <div class="mb-3">
                <label for="exampleInputAddress2" class="form-label">Birthday</label>
                <input name="birthday" value="" type="date" class="form-control"
                       id="exampleInputAddress2">
            </div>





            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>


<jsp:include page="/layout/js.jsp"/>

<script>
    $('#multiple-select-field').select2({
        theme: "bootstrap-5",
        width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
        placeholder: $(this).data('placeholder'),
        closeOnSelect: false,
    });
    // $("#multiple-select-field").on("select2:select select2:unselect", function (e) {
    //
    //     //this returns all the selected item
    //     var items= $(this).val();
    //
    // console.log(items)
    //
    // })


</script>
</body>
</html>
