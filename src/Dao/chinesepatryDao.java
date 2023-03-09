package Dao;

import utils.JDBCutils;

import java.sql.*;

public class chinesepatryDao {
    public static ResultSet selectAll() throws SQLException, ClassNotFoundException {//将数据库中的数据都读取出来
        String sql = "select * from chinesepatry";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }

    public static int add(String name, float price,String produceDate,String state) throws SQLException, ClassNotFoundException {//添加中式糕点数据
        String sql = "insert into chinesepatry(name,price,produceDate,state) values(?,?,?,?)";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setFloat(2,price);
        pstmt.setString(3,produceDate);
        pstmt.setString(4,state);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static int nameDelete(String name) throws SQLException, ClassNotFoundException {//根据糕点名称删除中式糕点数据
        String sql = "delete from chinesepatry where name=?";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static int idDelete(int id) throws SQLException, ClassNotFoundException {//根据编号删除中式糕点数据
        String sql = "delete from chinesepatry where id=?";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setInt(1,id);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static int priceUpdate(String name,float newprice) throws SQLException, ClassNotFoundException {//根据糕点名称修改中式糕点的价格
        String sql = "update chinesepatry set price = ? where name = ?";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setFloat(1,newprice);
        pstmt.setString(2,name);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static ResultSet searchName(String name) throws SQLException, ClassNotFoundException {//根据糕点的名称查询中式糕点
        String sql = "select * from chinesepatry where name = ?";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }

    public static ResultSet sort() throws SQLException, ClassNotFoundException {//按价格对中式糕点进行降序排列
        String sql = "SELECT * FROM patrymanagement.chinesepatry order by price desc";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
}
