package com.example.eadexam.DAO;

import com.example.eadexam.Entity.StudentScore;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;


public class StudentScoreDAO {
    private Connection connection;

    public StudentScoreDAO(Connection connection) {
        this.connection = connection;
    }

    // Phương thức thêm điểm cho sinh viên
    public boolean addStudentScore(int studentId, int subjectId, double score1, double score2) {
        String query = "INSERT INTO student_score_t (student_id, subject_id, score1, score2) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, subjectId);
            stmt.setDouble(3, score1);
            stmt.setDouble(4, score2);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Phương thức lấy điểm của một sinh viên (ví dụ)
    public List<StudentScore> getStudentScores(int studentId) {
        List<StudentScore> scores = new ArrayList<>();
        String query = "SELECT * FROM student_score_t WHERE student_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    StudentScore score = new StudentScore(
                            rs.getInt("student_id"),
                            rs.getInt("subject_id"),
                            rs.getDouble("score1"),
                            rs.getDouble("score2")
                    );
                    scores.add(score);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }
}

