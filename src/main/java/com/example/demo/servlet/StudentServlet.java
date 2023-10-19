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

        // Thêm dữ liệu vào cơ sở dữ liệu và truy vấn danh sách
        StudentEntity studentEntity = new StudentEntity("AAAA", "0123456");
        studentDAO.create(studentEntity);
        List<StudentEntity> studentEntityList = studentDAO.all();

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Student List</h1>");

        // Kiểm tra nếu danh sách không rỗng
        if (!studentEntityList.isEmpty()) {
            out.println("<table border=\"1\">");
            out.println("<tr><th>Name</th><th>ID</th></tr>");

            for (StudentEntity student : studentEntityList) {
                out.println("<tr>");
                out.println("<td>" + student.getName() + "</td>");
                out.println("<td>" + student.getId() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        } else {
            out.println("<p>No students found.</p>");
        }

        out.println("</body></html>");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
