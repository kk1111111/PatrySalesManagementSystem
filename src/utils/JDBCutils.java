package utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutils {//与数据库建立连接的工具
    public static Connection getConnection() throws ClassNotFoundException, SQLException {//与数据库patryment建立连接
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/patrymanagement";
        String user = "root";
        String password = "2004525sakura";

        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }
}
