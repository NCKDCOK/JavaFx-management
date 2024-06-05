package org.example.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class JdbcUtil {

    static ResourceBundle  bundle = ResourceBundle.getBundle("db");

    // 数据库连接参数
    private static final String URL = bundle.getString("url");
    private static final String USERNAME =bundle.getString("username");
    private static final String PASSWORD = bundle.getString("password");

    // 数据库驱动类名
    private static final String DRIVER_CLASS_NAME = bundle.getString("driver");

    // 获取数据库连接方法
    public static Connection getConnection() throws SQLException {
        try {
            // 加载数据库驱动
            Class.forName(DRIVER_CLASS_NAME);
            // 获取数据库连接
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("加载jdbc驱动：driver 错误 " + DRIVER_CLASS_NAME, e);
        }
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
