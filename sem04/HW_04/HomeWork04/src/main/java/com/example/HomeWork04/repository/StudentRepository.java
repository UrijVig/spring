package com.example.HomeWork04.repository;


import com.example.HomeWork04.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    List<Student> students = new ArrayList<>();
    public void save (Student student){
        students.add(student);
    }
    public List<Student> getAll(){
        return students;
    }
}
