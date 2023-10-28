<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teacher List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row">

    <h1>Employee List</h1>

    <c:if test="${not empty employees}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Address</th>
                <th scope="col">Birthday</th>
                <th scope="col">Position</th>
                <th scope="col">Department</th>
                <th scope="col">ID</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td><c:out value="${employee.fullname}" /></td>
                    <td><c:out value="${employee.address}" /></td>
                    <td><c:out value="${employee.birthday}" /></td>
                    <td><c:out value="${employee.position}" /></td>
                    <td><c:out value="${employee.department}" /></td>

                    <td><c:out value="${employee.id}" /></td>


                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="pagination">
            <c:if test="${pageNumber > 1}">
                <a href="/employee-servlet?pageNumber=${pageNumber - 1}&pageSize=${pageSize}">Previous</a>
            </c:if>
            <c:forEach begin="1" end="${totalPages}" var="i">
                <c:choose>
                    <c:when test="${pageNumber eq i}">
                        <a href="/employee-servlet?pageNumber=${i}&pageSize=${pageSize}"><strong>${i}</strong></a>
                    </c:when>
                    <c:otherwise>
                        <a href="/employee-servlet?pageNumber=${i}&pageSize=${pageSize}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${pageNumber < totalPages}">
                <a href="/employee-servlet?pageNumber=${pageNumber + 1}&pageSize=${pageSize}">Next</a>
            </c:if>
        </div>
    </c:if>
    <c:if test="${empty employees}">
        <p>No employees found.</p>
    </c:if>


</div>
</div>
</body>
</html>
