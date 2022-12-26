package Dao;

import utils.JDBCutils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class westernpatryDao {
    public static ResultSet selectAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from westernpatry";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }

    public static int add(String name, float price,String produceDate,String state) throws SQLException, ClassNotFoundException {
        String sql = "insert into westernpatry(name,price,produceDate,state) values(?,?,?,?)";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setFloat(2,price);
        pstmt.setString(3,produceDate);
        pstmt.setString(4,state);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static int nameDelete(String name) throws SQLException, ClassNotFoundException {
        String sql = "delete from westernpatry where name=?";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static int priceUpdate(String name,float newprice) throws SQLException, ClassNotFoundException {
        String sql = "update westernpatry set price = ? where name = ?";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setFloat(1,newprice);
        pstmt.setString(2,name);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static ResultSet selectName(String name) throws SQLException, ClassNotFoundException {
        String sql = "select * from westernpatry where name = ?";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
}
