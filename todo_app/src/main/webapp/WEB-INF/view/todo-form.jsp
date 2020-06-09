<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save Todo</title>


    <style>
        .error {color:red}
    </style>
    <link type="text/css"
          rel="stylesheet"
          href="static/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="static/css/add-style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>ToDO Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Customer</h3>

    <form:form action="saveTodo" modelAttribute="todo" method="POST">
        <form:hidden path="id" />
        <div class="form-group">
            <label>Description</label>
            <form:input type="text" path="description"/>
            <form:errors path="description" cssClass="error" />
        </div>

        <br/>
        <div class="form-group">
            <label>Date</label>
            <form:input type="date" path="todo_date"/>
            <form:errors path="todo_date" cssClass="error" />

        </div>
        <br/>
        <input type="submit" value="Save" class="save"/>
    </form:form>

    <p>
        <a href="${pageContext.request.contextPath}/todo/listTodos">Back to List</a>
    </p>

</div>

</body>

</html>








