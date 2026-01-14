package com.practice.super_server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Tells spring: "I server HTML files"
public class GradeController {

    private final StudentService service;

    public GradeController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/grades")
    public String showGradebook(Model model) {
        // Get the data
        // var students = repo.findAll();

        // put the data in the "backpack" (model) to send to HTML
        model.addAttribute("studentList", service.getAllStudents());
        return "grades";

        // // return the name of the HTML file without .html
        // return "grades";
    }

    @PostMapping("/grades")
    public String addStudentFromForm(@RequestParam String name, @RequestParam Double score) {

        System.out.println("📢 CONTROLLER RECEIVED: " + name + " with score " + score);
        Student newStudent = new Student(name, score);
        service.addStudent(newStudent);
        // TODO: process POST request

        return "redirect:/grades";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Long id) {
        service.deleteStudent(id);
        return "redirect:/grades";
    }

}
