package com.example.eadexam.Controller;

import com.example.eadexam.DAO.StudentDAO;
import com.example.eadexam.DAO.StudentScoreDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;
    // Khởi tạo DAO và kết nối
    // Khởi tạo DAO và kết nối cơ sở dữ liệu
    @Override
    public void init() throws ServletException {
        try {
            String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
            String jdbcUsername = "root";
            String jdbcPassword = "password";
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            studentDAO = new StudentDAO(connection);
        } catch (SQLException e) {
            throw new ServletException("Database connection error", e);
        }
    }
    // Xử lý thêm sinh viên
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Nhận tham số từ form
        String studentCode = request.getParameter("studentCode");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");

        // Thêm sinh viên vào cơ sở dữ liệu thông qua DAO
        boolean isAdded = studentDAO.addStudent(studentCode, fullName, address);

        // Thiết lập thông báo thành công hoặc thất bại
        if (isAdded) {
            request.setAttribute("message", "Sinh viên đã được thêm thành công!");
        } else {
            request.setAttribute("message", "Có lỗi khi thêm sinh viên.");
        }

        // Chuyển hướng hoặc hiển thị kết quả
        request.getRequestDispatcher("/addStudentResult.jsp").forward(request, response);
    }


}
