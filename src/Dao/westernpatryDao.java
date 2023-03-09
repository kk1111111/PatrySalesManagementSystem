package Dao;

import utils.JDBCutils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class westernpatryDao {
    public static ResultSet selectAll() throws SQLException, ClassNotFoundException {//将数据库中的数据都读取出来
        String sql = "select * from westernpatry";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }

    public static int add(String name, float price,String produceDate,String state) throws SQLException, ClassNotFoundException {//添加西式糕点数据
        String sql = "insert into westernpatry(name,price,produceDate,state) values(?,?,?,?)";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setFloat(2,price);
        pstmt.setString(3,produceDate);
        pstmt.setString(4,state);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static int nameDelete(String name) throws SQLException, ClassNotFoundException {//根据糕点名称删除西式糕点数据
        String sql = "delete from westernpatry where name=?";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static int idDelete(int id) throws SQLException, ClassNotFoundException {//根据编号删除西式糕点数据
        String sql = "delete from westernpatry where id=?";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setInt(1,id);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static int priceUpdate(String name,float newprice) throws SQLException, ClassNotFoundException {//根据糕点名称修改西式糕点的价格
        String sql = "update westernpatry set price = ? where name = ?";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setFloat(1,newprice);
        pstmt.setString(2,name);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static ResultSet searchName(String name) throws SQLException, ClassNotFoundException {//根据糕点的名称查询西式糕点
        String sql = "select * from westernpatry where name = ?";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setString(1,name);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }

    public static ResultSet sort() throws SQLException, ClassNotFoundException {//按价格对西式糕点进行降序排列
        String sql = "SELECT * FROM patrymanagement.westernpatry order by price desc";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
}
