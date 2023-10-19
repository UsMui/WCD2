package com.example.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet("/upload-file")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<html><body>");
        resp.getWriter().write("<form action='upload-file' method='post' enctype='multipart/form-data'>");
        resp.getWriter().write("<input type='file' name='file' /><br />");
        resp.getWriter().write("<input type='submit' value='Upload File' />");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadDir = "C:\\Users\\MystUphng\\IdeaProjects\\demo\\src\\main\\java\\com\\example\\demo\\upload";
        for (Part part : req.getParts()) {
            String fileName = getSubmittedFileName(part);
            if (fileName != null) {
                String filePath = uploadDir + File.separator + fileName;
                try (InputStream input = part.getInputStream()) {
                    Files.copy(input, Paths.get(filePath));
                }
            }
        }
        resp.setContentType("text/html");
        resp.getWriter().write("<html><body>");
        resp.getWriter().write("File uploaded successfully!");
        resp.getWriter().write("</body></html>");
    }

    private String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                if (!fileName.isEmpty()) {
                    return fileName;
                }
            }
        }
        return null;
    }
}
