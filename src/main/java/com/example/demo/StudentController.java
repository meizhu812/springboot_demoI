package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
class StudentController {
    private final StudentRepository students;

    public StudentController(StudentRepository students) {
        this.students = students;
    }

    @PostMapping("/new")
    String appendStudent(@RequestBody Student newStudent) {
        System.out.println(newStudent);
        if (students.existsById(newStudent.getName())) {
            return "姓名重复";
        } else {
            students.createStudent(newStudent.getName(), newStudent.getGender(), newStudent.getClassId());
            return "添加成功";
        }
    }

    @DeleteMapping
    String deleteStudentByName(@RequestParam String name) {
        if (!students.existsById(name)) {
            return "该学生不存在";
        } else {
            students.deleteById(name);
            return "删除成功";
        }
    }

    @GetMapping("/all")
    Iterable<Student> getAllStudents() {
        return students.findAll();
    }

    @GetMapping
    Optional<Student> getStudentByName(@RequestParam String name) {
        return students.findById(name);
    }
}
