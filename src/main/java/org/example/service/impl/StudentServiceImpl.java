package org.example.service.impl;

import org.example.dao.impl.StudentDaoImpl;
import org.example.entity.Student;
import org.example.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDaoImpl studentDao = new StudentDaoImpl();

    @Override
    public int add(Student student) {
        if (!student.getName().isEmpty() && !student.getSex().isEmpty() && !student.getStuId().isEmpty() &&
                !student.getCla().isEmpty() && !student.getBirth().isEmpty() && !student.getProfession().isEmpty()) {
            return studentDao.add(student);
        } else {
            return -1;
        }

    }

    @Override
    public int delete(String stuId) {
        if(stuId.isEmpty()) {
            return -1;
        }

         return studentDao.delete(stuId);

    }

    @Override
    public int update(Student student) {
        if (!student.getName().isEmpty() && !student.getSex().isEmpty() && !student.getStuId().isEmpty() &&
                !student.getCla().isEmpty() && !student.getBirth().isEmpty() && !student.getProfession().isEmpty()) {
            return studentDao.update(student);
        } else {
            return -1;
        }

    }

    @Override
    public List<Student> queryBy(String option, String queryValue) {
        return studentDao.queryBy(option, queryValue);
    }

    @Override
    public List<Student> query() {
        return studentDao.query();
    }

    @Override
    public Student select(String stuId) {
        return studentDao.select(stuId);
    }
}
