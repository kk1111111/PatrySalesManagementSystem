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
}
