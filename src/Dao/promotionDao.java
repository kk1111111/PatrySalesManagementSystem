package Dao;

import utils.JDBCutils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class promotionDao {
    public static int chinesepatryP() throws SQLException, ClassNotFoundException {
        String sql = "update chinesepatry set price = price*0.8";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static int westernpatryP() throws SQLException, ClassNotFoundException {
        String sql = "update westernpatry set price = price*0.8";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static int patryP() throws SQLException, ClassNotFoundException {
        String sql1 = "update chinesepatry set price = price*0.8";
        String sql2 = "update westernpatry set price = price*0.8";
        PreparedStatement pstmt1 = JDBCutils.getConnection().prepareStatement(sql1);
        PreparedStatement pstmt2 = JDBCutils.getConnection().prepareStatement(sql2);
        int count1 = pstmt1.executeUpdate();
        int count2 = pstmt2.executeUpdate();
        int count = count1+count2;
        return count;
    }

    public static int back1() throws SQLException, ClassNotFoundException {
        String sql = "update chinesepatry set price = price*1.25";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static int back2() throws SQLException, ClassNotFoundException {
        String sql = "update westernpatry set price = price*1.25";
        PreparedStatement pstmt = JDBCutils.getConnection().prepareStatement(sql);
        int count = pstmt.executeUpdate();
        return count;
    }

    public static int back3() throws SQLException, ClassNotFoundException {
        String sql1 = "update chinesepatry set price = price*1.25";
        String sql2 = "update westernpatry set price = price*1.25";
        PreparedStatement pstmt1 = JDBCutils.getConnection().prepareStatement(sql1);
        PreparedStatement pstmt2 = JDBCutils.getConnection().prepareStatement(sql2);
        int count1 = pstmt1.executeUpdate();
        int count2 = pstmt2.executeUpdate();
        int count = count1+count2;
        return count;
    }
}
