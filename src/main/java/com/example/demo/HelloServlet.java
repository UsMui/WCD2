package com.example.demo;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.impl.CustomerDAOimpl;
import com.example.demo.entity.CustomerEntity;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private CustomerDAO customerDAO;

    public void init() {
        message = "Hello World!";
        customerDAO = new CustomerDAOimpl();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        CustomerEntity customerEntity = new CustomerEntity("T2203E FPT", 25, "B6");
        customerDAO.createCustomer(customerEntity);
        List <CustomerEntity> customerEntityList = customerDAO.getAllCustomer();
        request.setAttribute("customers",customerEntityList);
//        request.getRequestDispatcher()
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}