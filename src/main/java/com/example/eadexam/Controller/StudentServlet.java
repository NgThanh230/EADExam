package com.example.eadexam.Controller;

import com.example.eadexam.DAO.StudentDAO;
import com.example.eadexam.Entity.Student;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/studentList")
public class StudentServlet extends HttpServlet {
    private com.example.eadexam.DAO.StudentDAO StudentDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Student> students = StudentDAO.getAllStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("/studentList.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}
