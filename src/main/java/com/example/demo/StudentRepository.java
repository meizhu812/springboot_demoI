package com.example.demo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
    @Modifying
    @Query("INSERT INTO spring_demo.student (name, gender, class_id) VALUES (:name, :gender, :classId);")
    void createStudent(String name, String gender, String classId);
}
