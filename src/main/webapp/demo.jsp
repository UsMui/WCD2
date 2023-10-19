<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/12/2023
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorPage.jsp" %>
<html>
<head>
    <title>Demo</title>
</head>
<body>
<h1>Demo jsp page</h1>
<h1>Expression</h1>
<%
    int c = 300;
    int d = c + 10;


    //scope
    String sessionValue =(String) session.getAttribute("session");
    String applicationValue = (String) application.getAttribute("application");
%>
<%! int a = 200; String b = "T2203E"; %>
<h3><%= 10 + 40 + 50 %></h3>
<h3><%= a %></h3>
<h3><%= b %></h3>
<h3><%= d %></h3>
<%@ include file="footer.jsp"%>
</body>
</html>