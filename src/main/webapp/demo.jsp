<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Admin--%>
<%--  Date: 10/12/2023--%>
<%--  Time: 8:48 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ page errorPage="errorPage.jsp" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Demo</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Demo jsp page</h1>--%>
<%--<h1>Expression</h1>--%>
<%--<%--%>
<%--    int c = 300;--%>
<%--    int d = c + 10;--%>


<%--    //scope--%>
<%--    String sessionValue =(String) session.getAttribute("session");--%>
<%--    String applicationValue = (String) application.getAttribute("application");--%>
<%--%>--%>
<%--<%! int a = 200; String b = "T2203E"; %>--%>
<%--<h3><%= 10 + 40 + 50 %></h3>--%>
<%--<h3><%= a %></h3>--%>
<%--<h3><%= b %></h3>--%>
<%--<h3><%= d %></h3>--%>
<%--<%@ include file="footer.jsp"%>--%>
<%--</body>--%>
<%--</html>--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<form action="/student-servlet" method="POST">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"><br><br>
    <label for="tel">Telephone:</label>
    <input type="text" id="tel" name="tel"><br><br>

    <input type="submit" value="Create">
</form>

<form action="/student-servlet/update" method="POST">

    <label >ID: ${student.id}</label>
    <input type="hidden" value="${student.id}"  name="id"><br><br>
    <label >Name:</label>
    <input type="text" value="${student.name}"  name="name"><br><br>
    <label for="tel">Telephone:</label>
    <input type="text" value="${student.tel}"  name="tel"><br><br>

    <input type="submit" value="Update">
</form>


<h1>Student List</h1>
<c:if test="${not empty students}">
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Telephone</th>


            <th>ID</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td><c:out value="${student.name}" /></td>
                <td><c:out value="${student.tel}" /></td>

                <td><c:out value="${student.id}" /></td>
                <td>

<%--                    <form action="/student-servlet" method="POST">--%>
<%--                        <input type="hidden" name="id" value="<c:out value="${student.id}" />" />--%>
<%--                        <input type="submit" value="Update" />--%>
<%--                    </form>--%>
                    <form action="/student-servlet/delete" method="GET">
                        <input type="hidden" name="id" value="<c:out value="${student.id}" />" />
                        <input type="hidden" name="name" value="<c:out value="${student.name}" />" />
                        <input type="hidden" name="tel" value="<c:out value="${student.tel}" />" />

                        <input type="submit" value="Delete" />
                    </form>

                <form action="/student-servlet/getupdate" method="GET">
                    <input type="hidden" name="id" value="<c:out value="${student.id}" />" />


                    <input type="submit" value="GetUpdate" />
                </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty students}">
    <p>No students found.</p>
</c:if>
</body>
</html>





