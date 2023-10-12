package com.example.demo.servlet;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dao.impl.StudentDaoimpl;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.StudentEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

@WebServlet(value = "/student-servlet")
public class StudentServlet extends HttpServlet{
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDaoimpl();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        // Hello
        StudentEntity studentEntity = new StudentEntity("Usm","0123456");
        studentDAO.create(studentEntity);
        List<StudentEntity> studentEntityList = studentDAO.all();
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + studentEntityList.toString() + "</h1>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
