package Dao;

import utils.JDBCutils;

import java.sql.*;

public class chinesepatryDao {
    public static ResultSet selectAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from chinesepatry";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }

    public static int add(String name, float price,String produceDate,String state) throws SQLException, ClassNotFoundException {
        String sql = "insert into chinesepatry(name,price,produceDate,state) values(?,?,?,?)";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setFloat(2,price);
        pstmt.setString(3,produceDate);
        pstmt.setString(4,state);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static int nameDelete(String name) throws SQLException, ClassNotFoundException {
        String sql = "delete from chinesepatry where name=?";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        int count = pstmt.executeUpdate();
        return count;
    }

}
