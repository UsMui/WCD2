<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6">
            <h1>CREATE STUDENT</h1>
            <form action="/student-servlet" method="POST" class="mb-5">
                <div class="mb-3">
                    <label for="name" class="form-label">Name:</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="mb-3">
                    <label for="tel" class="form-label">Telephone:</label>
                    <input type="text" class="form-control" id="tel" name="tel">
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>
        </div>
        <div class="col-md-6">
            <h1>UPDATE STUDENT ID ${student.id}</h1>
            <form action="/student-servlet/sua" method="POST" class="mb-5">
                <div class="mb-3">

                    <input type="hidden" value="${student.id}" name="id" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">Name:</label>
                    <input type="text" value="${student.name}" name="name" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="tel" class="form-label">Telephone:</label>
                    <input type="text" value="${student.tel}" name="tel" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Update</button>
            </form>
        </div>
    </div>

    <h1>Student List</h1>
    <c:if test="${not empty students}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Telephone</th>
                <th scope="col">ID</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td><c:out value="${student.name}" /></td>
                    <td><c:out value="${student.tel}" /></td>
                    <td><c:out value="${student.id}" /></td>
                    <td>
                        <form action="/student-servlet/delete" method="GET" class="d-inline" onsubmit="return confirm('Are you sure you want to delete this student?');">
                            <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
                            <input type="hidden" name="name" value="<c:out value='${student.name}' />" />
                            <input type="hidden" name="tel" value="<c:out value='${student.tel}' />" />
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                        <form action="/student-servlet/getupdate" method="GET" class="d-inline">
                            <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
                            <button type="submit" class="btn btn-secondary">GetUpdate</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty students}">
        <p>No students found.</p>
    </c:if>
</div>
</body>
</html>
