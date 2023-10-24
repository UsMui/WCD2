package com.example.demo.servlet;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dao.impl.StudentDaoimpl;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.StudentEntity;
import com.google.protobuf.TextFormat;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet({
        "/student-servlet",
        "/student-servlet/delete",
        "/student-servlet/getupdate",
        "/student-servlet/sua",
        "/student-servlet/search"



})
@MultipartConfig
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
        if(url.contains("search")){
            String name = request.getParameter("searchName");
            List<StudentEntity> studentsearchs = studentDAO.searchByName(name);
            if (studentsearchs != null) {
                request.setAttribute("studentsearchs", studentsearchs);

            }
        }
        int pageNumber = request.getParameter("pageNumber") != null ? Integer.parseInt(request.getParameter("pageNumber")) : 1;
        int pageSize = request.getParameter("pageSize") != null ? Integer.parseInt(request.getParameter("pageSize")) : 3;


            List<StudentEntity> studentEntityList = studentDAO.all(pageNumber,pageSize);
            int totalStudents = studentDAO.all().size();
            int totalPages = (int) Math.ceil((double) totalStudents / pageSize);
            request.setAttribute("pageNumber", pageNumber);
            request.setAttribute("pageSize", pageSize);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("students", studentEntityList);
            request.getRequestDispatcher("/demo.jsp").forward(request,response);

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath();
        if (action.equals("/student-servlet/sua")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String birthdayStr = request.getParameter("birthday");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = null;
            try {
                birthday = formatter.parse(birthdayStr);
            } catch (ParseException e) {
                e.printStackTrace(); // Handle the exception properly
            }
            String tel = request.getParameter("tel");

            // Thay đổi thành đường dẫn tới thư mục upload của bạn
            String uploadDirectory = "C:\\Users\\MystUphng\\IdeaProjects\\demo\\src\\main\\webapp\\upload";

            // Tạo thư mục upload nếu nó chưa tồn tại
            File uploadDir = new File(uploadDirectory);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            Part part = request.getPart("thumbnail");
            String fileName = part.getSubmittedFileName();
            String uploadPath = uploadDirectory + File.separator + fileName;
            File file = new File(uploadPath);
            try (InputStream input = part.getInputStream()) {
                Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File has been saved at: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            StudentEntity student = new StudentEntity();
            student.setId(Integer.parseInt(id));
            student.setName(name);
            student.setTel(tel);
            student.setBirthday(birthday);
            student.setThumbnail(fileName);
            studentDAO.update(student);

            List<StudentEntity> studentEntityList = studentDAO.all();
            request.setAttribute("students", studentEntityList);
            request.getRequestDispatcher("/demo.jsp").forward(request,response);
        }

        String name = request.getParameter("name");
        String birthdayStr = request.getParameter("birthday");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = formatter.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        String tel = request.getParameter("tel");

        // Thay đổi thành đường dẫn tới thư mục upload của bạn
        String uploadDirectory = "C:\\Users\\MystUphng\\IdeaProjects\\demo\\src\\main\\webapp\\upload";

        // Tạo thư mục upload nếu nó chưa tồn tại
        File uploadDir = new File(uploadDirectory);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        Part part = request.getPart("thumbnail");
        String fileName = part.getSubmittedFileName();
        String uploadPath = uploadDirectory + File.separator + fileName;
        File file = new File(uploadPath);
        try (InputStream input = part.getInputStream()) {
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File has been saved at: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        StudentEntity newStudent = new StudentEntity(name, tel,fileName, birthday);
        studentDAO.create(newStudent);

             // Create student in the database

        response.sendRedirect("student-servlet");


    }



}
