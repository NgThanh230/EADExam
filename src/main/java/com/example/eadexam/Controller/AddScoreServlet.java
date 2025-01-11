package com.example.eadexam.Controller;

import com.example.eadexam.DAO.StudentDAO;
import com.example.eadexam.DAO.StudentScoreDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.eadexam.DAO.StudentScoreDAO;
import com.example.eadexam.Entity.StudentScore;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/addScore")
public class AddScoreServlet extends HttpServlet {
    private StudentScoreDAO studentScoreDAO;

    // Khởi tạo DAO và kết nối
    @Override
    public void init() throws ServletException {
        try {
            String jdbcURL = "jdbc:mysql://localhost:3306/sis";
            String jdbcUsername = "root";
            String jdbcPassword = "";
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            studentScoreDAO = new StudentScoreDAO(connection);
        } catch (SQLException e) {
            throw new ServletException("Database connection error", e);
        }
    }

    // Xử lý thêm điểm
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Nhận tham số từ form
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        double score1 = Double.parseDouble(request.getParameter("score1"));
        double score2 = Double.parseDouble(request.getParameter("score2"));

        // Thêm điểm vào cơ sở dữ liệu thông qua DAO
        boolean isAdded = studentScoreDAO.addStudentScore(studentId, subjectId, score1, score2);

        // Thiết lập thông báo thành công hoặc thất bại
        if (isAdded) {
            request.setAttribute("message", "Điểm đã được thêm thành công!");
        } else {
            request.setAttribute("message", "Có lỗi khi thêm điểm.");
        }

        // Chuyển hướng hoặc hiển thị kết quả
        request.getRequestDispatcher("/add-score.jsp").forward(request, response);
    }

}

