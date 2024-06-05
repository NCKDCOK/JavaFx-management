package org.example.dao.impl;

import org.example.dao.LoginDao;
import org.example.entity.User;
import org.example.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User login(String username) {
        User user = new User();

        //建立连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtil.getConnection();
            //查询数据库
            String sql = "select * from user where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                user.setName((resultSet.getString("name")));
                user.setPassword(resultSet.getString("password"));
                return user;
            }



            //返回结果
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }

}
