package com.example.eadexam.DAO;

import com.example.eadexam.Entity.Student;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class StudentDAO {
    @PersistenceContext
    private EntityManager em;

    public void insertStudent(Student student) {
        em.persist(student);
    }

    public List<Student> getAllStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }
}

