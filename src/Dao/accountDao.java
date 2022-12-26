package Dao;

import utils.JDBCutils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class accountDao {
    public static int addAccount(String user,String password) throws SQLException, ClassNotFoundException {
        String sql = "insert into account(user,password) values(?,?);";
        PreparedStatement pStatement = JDBCutils.getConnection().prepareStatement(sql);
        pStatement.setString(1,user);
        pStatement.setString(2,password);
        int count = pStatement.executeUpdate();
        return count;
    }
    public static int checkAccount(String user,String password) throws SQLException, ClassNotFoundException {
        String sql = "select * from account where user=? and password =?";
        PreparedStatement pStatement = JDBCutils.getConnection().prepareStatement(sql);
        pStatement.setString(1,user);
        pStatement.setString(2,password);
        ResultSet rs = pStatement.executeQuery();
        if(rs.next()){
            return 1;
        }else {
            return 0;
        }
    }
}
