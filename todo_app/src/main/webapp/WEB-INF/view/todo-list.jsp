<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>

<head>
    <link rel="stylesheet" href="webjars/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>List ToDos</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="static/css/style.css" />

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>ToDos Manager.</h2>
    </div>
</div>
<input type="button" onclick="window.location.href='showFormForAdd'; return false"
       class="add-button" value="Add New ToDo">
<br/><br/>
<div id="container">
    <div id="content">
        <table class="table">
            <thead class="thead-light">
            <tr>
                <th scope="col">Description</th>
                <th scope="col">Date</th>
                <th scope="col">Links</th>

            </tr>

            <c:forEach var="temp" items="${todos}">
            <c:url var="updateLink" value="/todo/showFormForUpdate">
                <c:param name="id" value="${temp.id}" />
            </c:url>
            <c:url var="deleteLink" value="/todo/deleteTodo">
                <c:param name="id" value="${temp.id}" />
            </c:url>
            <tr>
                <td> ${temp.description} </td>
                <td> ${temp.todo_date} </td>
                <td>
                    <a href="${updateLink}">Update</a>
                    <a href="${deleteLink}">Delete</a>
                </td>

            </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>







