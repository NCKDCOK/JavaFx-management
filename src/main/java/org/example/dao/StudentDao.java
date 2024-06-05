package org.example.dao;

import org.example.entity.Student;

import java.util.List;

public interface StudentDao {
    int add(Student student);

    int delete(String stuId);

    int update(Student student);

    Student select(String stuId);

    List<Student> query();

    List<Student> queryBy(String option, String queryValue);

}
