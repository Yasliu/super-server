package com.practice.super_server;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PathVariable;

@RestController // Tells Spring: this guy is a waiter/handler
public class TestController {

    private final StudentRepository studentRepository;

    public TestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // @GetMapping("/hello/{name}") // The context: Listen for "/hello"
    // public String sayHello(@RequestParam(value = "name", defaultValue = "World")
    // String name) {
    // return "Hello, " + name;
    // }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
