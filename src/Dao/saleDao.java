package Dao;

import utils.JDBCutils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class saleDao {
    public static ResultSet selectAll() throws SQLException, ClassNotFoundException {////将数据库中的数据都读取出来
        String sql = "select * from sale";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }

    public static int add(String date,String method,float sum) throws SQLException, ClassNotFoundException {//添加贸易订单的数据
        String sql = "insert into sale(date,method,sum) values(?,?,?);";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setString(1,date);
        pstmt.setString(2,method);
        pstmt.setFloat(3,sum);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static ResultSet search(String date) throws SQLException, ClassNotFoundException {//根据日期查询贸易订单
        String sql = "select * from sale where date=?";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        pstmt.setString(1,date);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
}
