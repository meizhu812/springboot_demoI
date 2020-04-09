package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("student")
public class Student {
    @Id
    private String name;
    private String gender;
    @Column("class_id")
    private String classId;
}
