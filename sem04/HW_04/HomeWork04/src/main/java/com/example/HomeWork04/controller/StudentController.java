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

    /**
     * Метод для отображения списка студентов
     *
     * @param model модель представления Spring MVC
     * @return шоблон страницы для отображения
     */
    @GetMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students", sr.getAll());
        return "student-form";
    }

    /**
     * Метод для отображения списка студентов и добавлении нового студента в БД
     *
     * @param s - объект класса Student
     * @param model модель представления Spring MVC
     * @return шоблон страницы для отображения
     */
    @PostMapping("/students")
    public String addStudent(Student s, Model model){
        sr.save(s);
        model.addAttribute("students", sr.getAll());
        return "student-form";
    }



}
