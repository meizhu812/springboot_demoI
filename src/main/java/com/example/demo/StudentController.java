package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
class StudentController {
    private final Set<Student> students = new HashSet<>();

    @PostMapping("/new")
    String appendStudent(@RequestBody Student newStudent) {
        return students.add(newStudent)
                ? "添加成功"
                : "姓名重复";
    }

    @DeleteMapping
    String deleteStudentByName(@RequestParam String name) {
        return students.removeIf(student -> student.getName().equals(name))
                ? "删除成功"
                : "该学生不存在";
    }

    @GetMapping("/all")
    Set<Student> getAllStudents() {
        return students;
    }

    @GetMapping
    Optional<Student> getStudentByName(@RequestParam String name) {
        return students.stream()
                .filter(student -> student.getName().equals(name))
                .findFirst();
    }
}
