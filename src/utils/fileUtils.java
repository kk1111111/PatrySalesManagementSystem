package utils;

import Dao.chinesepatryDao;
import Dao.saleDao;
import Dao.westernpatryDao;
import domain.chinesePatry;
import domain.sale;
import domain.westernPatry;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class fileUtils {
    public static void exportSale() throws SQLException, ClassNotFoundException, IOException {
        Vector<sale> data = new Vector<>();
        data = requestSaleData(data);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("salefile\\saledata.txt"));
        for(int i = 0 ; i < data.size();i++){
            oos.writeObject(data.elementAt(i));
        }
        oos.close();
    }
    public static Vector<sale> requestSaleData(Vector<sale> tableData) throws SQLException, ClassNotFoundException {
        ResultSet rs = saleDao.selectAll();
        sale sale = null;
        while(rs.next()){
            int id = rs.getInt("id");
            String date = rs.getString("date");
            String method = rs.getString("method");
            float sum = rs.getFloat("sum");

            sale = new sale(id,date,method,sum);

            tableData.add(sale);
        }
        return tableData;
    }

    public static void exportChinesePatry() throws SQLException, ClassNotFoundException, IOException {
        Vector<chinesePatry> data = new Vector<>();
        data = requestChinesePatryData(data);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("salefile\\chinesepatryData.txt"));
        for(int i = 0 ; i < data.size();i++){
            oos.writeObject(data.elementAt(i));
        }
        oos.close();
    }

    public static Vector<chinesePatry> requestChinesePatryData(Vector<chinesePatry> tableData) throws SQLException, ClassNotFoundException {
        ResultSet rs = chinesepatryDao.selectAll();
        chinesePatry chinesepatry = null;
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            String produceDate = rs.getString("produceDate");
            String state = rs.getString("state");

            chinesepatry = new chinesePatry(id,name,price,produceDate,state);

            tableData.add(chinesepatry);
        }
        return tableData;
    }

    public static void exportWesternPatry() throws SQLException, ClassNotFoundException, IOException {
        Vector<westernPatry> data = new Vector<>();
        data = requestWesternPatryData(data);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("salefile\\westernpatryData.txt"));
        for(int i = 0 ; i < data.size();i++){
            oos.writeObject(data.elementAt(i));
        }
        oos.close();
    }

    public static Vector<westernPatry> requestWesternPatryData(Vector<westernPatry> tableData) throws SQLException, ClassNotFoundException {
        ResultSet rs = westernpatryDao.selectAll();
        westernPatry westernpatry = null;
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            String produceDate = rs.getString("produceDate");
            String state = rs.getString("state");

            westernpatry = new westernPatry(id,name,price,produceDate,state);


            tableData.add(westernpatry);
        }
        return tableData;
    }
}
