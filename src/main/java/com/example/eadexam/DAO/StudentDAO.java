package com.example.eadexam.DAO;

import com.example.eadexam.Entity.Student;
import com.example.eadexam.Entity.StudentScore;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection connection;

    // Constructor
    public StudentDAO(Connection connection) {
        this.connection = connection;
    }
    //thêm sinh viên
    public boolean addStudent(String studentCode, String fullName, String address) {
        String query = "INSERT INTO student_t (student_code, full_name, address) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, studentCode);
            stmt.setString(2, fullName);
            stmt.setString(3, address);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Lấy danh sách sinh viên
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student_t";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("student_id"));
                student.setFullName(rs.getString("full_name"));
                student.setAddress(rs.getString("address"));

                // Lấy điểm số của sinh viên
                List<StudentScore> scores = getStudentScores(student.getStudentId());
                student.setScores(scores);

                students.add(student);
            }
        }
        return students;
    }

    // Lấy điểm số của sinh viên
    private List<StudentScore> getStudentScores(int studentId) throws SQLException {
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
        }
        return scores;
    }
}


