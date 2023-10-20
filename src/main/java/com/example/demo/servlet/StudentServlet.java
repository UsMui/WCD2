package com.example.demo.servlet;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dao.impl.StudentDaoimpl;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.StudentEntity;

import javax.persistence.criteria.CriteriaBuilder;
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

@WebServlet({
        "/student-servlet",
        "/student-servlet/delete",
        "/student-servlet/getupdate",
        "/student-servlet/update"



})
public class StudentServlet extends HttpServlet{
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDaoimpl();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");
        if (url.contains("delete")){
            String id = request.getParameter("id");

            StudentEntity student = studentDAO.findOne(Integer.parseInt(id));
            if (student != null) {
                studentDAO.delete(student);

            }
        }
        if (url.contains("getupdate")){
            String id = request.getParameter("id");

            StudentEntity student = studentDAO.findOne(Integer.parseInt(id));
            if (student != null) {
                request.setAttribute("student", student);

            }
        }

            List<StudentEntity> studentEntityList = studentDAO.all();
            request.setAttribute("students", studentEntityList);
            request.getRequestDispatcher("/demo.jsp").forward(request,response);

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");

        if (url.contains("update")){
            String idd = request.getParameter("id");
            Integer id = Integer.parseInt(idd);

            String name = request.getParameter("name");
            String tel = request.getParameter("tel");
            StudentEntity student = new StudentEntity(id,name,tel);
            if(id!=null&&name!=null&&tel!=null){
                studentDAO.update(student);
                response.sendRedirect("student-servlet");
            }

        }else{
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");

            // Validate data here

            StudentEntity student = new StudentEntity(name,tel);
            studentDAO.create(student); // Create student in the database
            response.sendRedirect("student-servlet");


        }



    }









}
