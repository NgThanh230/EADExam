package com.example.eadexam.DAO;

import com.example.eadexam.Entity.StudentScore;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class StudentScoreDAO {
    @PersistenceContext
    private EntityManager em;

    public void insertStudentScore(StudentScore studentScore) {
        em.persist(studentScore);
    }

    public List<StudentScore> getScoresByStudent(int studentId) {
        return em.createQuery("SELECT ss FROM StudentScore ss WHERE ss.student.studentId = :studentId", StudentScore.class)
                .setParameter("studentId", studentId)
                .getResultList();
    }
}
