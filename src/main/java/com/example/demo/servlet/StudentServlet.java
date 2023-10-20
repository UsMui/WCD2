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
        "/student-servlet/sua"



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

        String action = request.getServletPath();
        if (action.equals("/student-servlet/sua")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");

            // Xử lý logic cập nhật sinh viên dựa trên id, name, và tel
            // Code xử lý cập nhật sinh viên ở đây
            // Ví dụ:
            StudentEntity student = new StudentEntity();
            student.setId(Integer.parseInt(id));
            student.setName(name);
            student.setTel(tel);
            studentDAO.update(student);

            // Sau khi cập nhật, chuyển hướng trở lại trang danh sách sinh viên
//            if (!response.isCommitted()) {
//                response.sendRedirect("student-servlet");
//            }
            List<StudentEntity> studentEntityList = studentDAO.all();
            request.setAttribute("students", studentEntityList);
            request.getRequestDispatcher("/demo.jsp").forward(request,response);
        }

            String name = request.getParameter("name");
            String tel = request.getParameter("tel");

            StudentEntity student = new StudentEntity(name,tel);
            if(name!=null&&tel!=null){
                studentDAO.create(student);
            }
             // Create student in the database

            response.sendRedirect("student-servlet");


    }









}
