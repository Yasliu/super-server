package com.practice.super_server;

import org.springframework.stereotype.Service;
import java.util.List;

@Service // Tells spring: "I am the logic manager"
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public void addStudent(Student student) {
        // Rule 1: No negative scores
        if (student.getScore() < 0) {
            System.out.println("Rejected: Score cannot be negative!");
            return;
        }

        // Rule 2: No scores over 100
        if (student.getScore() > 100) {
            System.out.println("Rejected: Score cannot be over 100!");
            return;
        }

        // if rules pass --> Save to DB
        repo.save(student);
        System.out.println("Accepted: " + student.getName());
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
