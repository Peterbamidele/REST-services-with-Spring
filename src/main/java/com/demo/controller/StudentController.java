package com.demo.controller;

import com.demo.repository.StudentRepository;
import com.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/all-students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PostMapping("/new-student")
    public Student createStudent( @RequestBody Student student){
        Student myStudent = new Student();

        myStudent.setFirstName(student.getFirstName());
        myStudent.setLastName(student.getLastName());
        studentRepository.save(myStudent);
        return  myStudent;
    }
}
