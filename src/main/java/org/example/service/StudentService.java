package org.example.service;

import org.example.entity.Student;

import java.util.List;

public interface StudentService {
    int add(Student student);
    int delete(String stuId);
    int update(Student student);
    List<Student> queryBy(String option, String queryValue);
    List<Student> query();
    Student select(String stuId);
}

