package com.example.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@WebServlet(value="/login-servlet")

public class LoginServlet extends HttpServlet {

    private final String username ="admin";
    private final String password ="admin";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.write("<html><body>");
        writer.write("<form action = 'login-servlet' method='POST'>");
        writer.write("<input type='text' name='username' />");
        writer.write("<input type='text' name='password' />");
        writer.write("<input type='submit' value='Submit' />");
        writer.write("</form>");
        writer.write("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 try{
     String username = req.getParameter("username");
     String password = req.getParameter("password");
     if(username.equals("admin")&&password.equals("admin")){
         HttpSession session = req.getSession();
         session.setAttribute("username",username);
         resp.sendRedirect("/");
     }
     else {
         resp.sendRedirect("/login-servlet");
     }

 }catch (Exception ex){
     log(ex.getMessage());
 }
    }
}
