package com.example.demo.servlet;


import com.example.demo.dao.EmployeeDAO;

import com.example.demo.dao.impl.EmployeeDAOimpl;
import com.example.demo.entity.EmployeeEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet({
        "/employee-servlet",
        "/employee-servlet/list"

})
@MultipartConfig
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDAOimpl();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");
        if(url.contains("list")){
            int pageNumber = request.getParameter("pageNumber") != null ? Integer.parseInt(request.getParameter("pageNumber")) : 1;
        int pageSize = request.getParameter("pageSize") != null ? Integer.parseInt(request.getParameter("pageSize")) : 3;


        List<EmployeeEntity> employeeEntities = employeeDAO.all(pageNumber,pageSize);
        int totalEmployees = employeeDAO.all().size();
        int totalPages = (int) Math.ceil((double) totalEmployees / pageSize);
        request.setAttribute("pageNumber", pageNumber);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("employees", employeeEntities);
        request.getRequestDispatcher("/list.jsp").forward(request,response);

        }

        request.getRequestDispatcher("/employee.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String birthdayStr = request.getParameter("birthday");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = formatter.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        String position = request.getParameter("position");
        String department = request.getParameter("department");
        EmployeeEntity newEmployee = new EmployeeEntity(fullname,birthday,address,position,department);
        employeeDAO.create(newEmployee);
        response.sendRedirect("employee-servlet");

    }
}
