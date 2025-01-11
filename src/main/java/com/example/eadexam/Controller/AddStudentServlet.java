package com.example.eadexam.Controller;

import com.example.eadexam.Entity.Student;
import com.example.eadexam.DAO.StudentDAO;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Inject
    private StudentDAO studentDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String studentCode = req.getParameter("studentCode");
        String fullName = req.getParameter("fullName");
        String address = req.getParameter("address");

        Student student = new Student();
        student.setStudentCode(studentCode);
        student.setFullName(fullName);
        student.setAddress(address);

        studentDAO.insertStudent(student);

        resp.sendRedirect("students.jsp");
    }
}

