package org.example.dao.impl;

import org.example.dao.StudentDao;
import org.example.entity.Student;
import org.example.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int add(Student student) {

        //建立连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JdbcUtil.getConnection();
            //查询数据库
            String sql = "insert into  students (name, stuid, cla, sex, birth, profession) value (?,?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            //设置对象
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getStuId());
            preparedStatement.setString(3, student.getCla());
            preparedStatement.setString(4, student.getSex());
            preparedStatement.setString(5, student.getBirth());
            preparedStatement.setString(6, student.getProfession());
            int resultSet= preparedStatement.executeUpdate();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            JdbcUtil.close(connection, preparedStatement, null);
        }

        return 0;
    }

    @Override
    public int delete( String stuId) {
        //建立连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JdbcUtil.getConnection();
            //查询数据库
            String sql = "delete from students where stuid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,stuId);
            int resultSet= preparedStatement.executeUpdate();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }{
            JdbcUtil.close(connection, preparedStatement, null);
        }

        return 0;


    }

    @Override
    public int update(Student student) {

        //建立连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JdbcUtil.getConnection();
            //查询数据库
            String sql = "update students set name=?, cla=?, sex=?, birth=?, profession=? where stuid = ?";
            preparedStatement = connection.prepareStatement(sql);

            // 设置参数
            preparedStatement.setString(1, student.getName()); // 设置name的值
            preparedStatement.setString(2, student.getCla()); // 设置cla的值
            preparedStatement.setString(3, student.getSex()); // 设置sex的值
            preparedStatement.setString(4, student.getBirth()); // 设置birth的值
            preparedStatement.setString(5, student.getProfession()); // 设置profession的值
            preparedStatement.setString(6, student.getStuId()); // 设置where子句中的stuid的值

            int resultSet = preparedStatement.executeUpdate();

            //返回结果
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();

        }{
            JdbcUtil.close(connection, preparedStatement, null);
        }
        return 0;

    }

    @Override
    public Student select(String stuId) {
        //建立连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtil.getConnection();
            //查询数据库
            String sql = "select name, stuid, cla, sex, birth, profession from students where stuid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,stuId);
            resultSet = preparedStatement.executeQuery();


            Student student = new Student();
            if(resultSet.next()) {

                student.setName(resultSet.getString("name"));
                student.setStuId(resultSet.getString("stuid"));
                student.setCla(resultSet.getString("cla"));
                student.setSex(resultSet.getString("sex"));
                student.setBirth(resultSet.getString("birth"));
                student.setProfession(resultSet.getString("profession"));


            }



            //返回结果
            return student;
        } catch (SQLException e) {
            e.printStackTrace();

        }{
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }

        return null;

    }

    @Override
    public List<Student> query() {
        //建立连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtil.getConnection();
            //查询数据库
            String sql = "select name, stuid, cla, sex, birth, profession from students ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            List<Student> students = new ArrayList<>();

            while(resultSet.next()) {
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                student.setStuId(resultSet.getString("stuid"));
                student.setCla(resultSet.getString("cla"));
                student.setSex(resultSet.getString("sex"));
                student.setBirth(resultSet.getString("birth"));
                student.setProfession(resultSet.getString("profession"));
                students.add(student);

            }
            System.out.println(students.size()
            );


            //返回结果
            return students;
        } catch (SQLException e) {
            e.printStackTrace();

        }{
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }

        return null;

    }

    @Override
    public List<Student> queryBy(String option, String queryValue) {
        //建立连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtil.getConnection();
            //查询数据库
            String sql = "select name, stuid, cla, sex, birth, profession from students where "+option+" = ? ";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,queryValue);
            resultSet = preparedStatement.executeQuery();

            List<Student> students = new ArrayList<>();

            while(resultSet.next()) {
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                student.setStuId(resultSet.getString("stuid"));
                student.setCla(resultSet.getString("cla"));
                student.setSex(resultSet.getString("sex"));
                student.setBirth(resultSet.getString("birth"));
                student.setProfession(resultSet.getString("profession"));
                students.add(student);

            }
            System.out.println(students.size()
            );


            //返回结果
            return students;
        } catch (SQLException e) {
            e.printStackTrace();

        }{
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }

        return null;
    }






}
