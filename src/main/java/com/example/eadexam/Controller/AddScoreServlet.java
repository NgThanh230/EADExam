package com.example.eadexam.Controller;

import com.example.eadexam.Entity.Student;
import com.example.eadexam.Entity.StudentScore;
import com.example.eadexam.Entity.Subject;
import com.example.eadexam.DAO.StudentScoreDAO;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addScore")
public class AddScoreServlet extends HttpServlet {
    @Inject
    private StudentScoreDAO studentScoreDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        int subjectId = Integer.parseInt(req.getParameter("subjectId"));
        double score1 = Double.parseDouble(req.getParameter("score1"));
        double score2 = Double.parseDouble(req.getParameter("score2"));

        StudentScore score = new StudentScore();
        score.setStudent(new Student(studentId)); // Set reference
        score.setSubject(new Subject(subjectId)); // Set reference
        score.setScore1(score1);
        score.setScore2(score2);

        studentScoreDAO.insertStudentScore(score);

        resp.sendRedirect("scores.jsp");
    }
}
