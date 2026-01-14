package com.practice.super_server;

import jakarta.persistence.*; // Tool for Database Mapping

@Entity // Tells Spring, this is a database row
@Table(name = "students") // Maps to the students table in SQLite

public class Student {
    @Id // Tells Spring, this is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells Spring, this is auto-incremented
    private Long id;

    private String name;
    private Double score;

    public Student() {

    }

    public Student(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    // Getter
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }

    // Setter
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
