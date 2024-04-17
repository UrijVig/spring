package com.example.HomeWork04.controller;


import com.example.HomeWork04.model.Student;
import com.example.HomeWork04.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
public class StudentController {
    StudentRepository sr = new StudentRepository();

    @GetMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students", sr.getAll());
        return "student-form";
    }
    @PostMapping("/students")
    public String addStudent(Student s, Model model){
        sr.save(s);
        model.addAttribute("students", sr.getAll());
        return "student-form";
    }



}
