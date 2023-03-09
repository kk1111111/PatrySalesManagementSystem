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

public class fileUtils {//用于把糕点信息和销售订单信息导入文件的工具
    public static void exportSale() throws SQLException, ClassNotFoundException, IOException {//利用字符缓冲输出流把Vector集合中的sale的各个成员变量分别写入文件saleData中
        Vector<sale> data = new Vector<>();
        data = requestSaleData(data);
        BufferedWriter bw = new BufferedWriter(new FileWriter("datafile\\saleData.txt"));
        for(sale s : data){
            String s1;
            bw.write(s1 = String.valueOf(s.getId()));
            bw.write(" ");
            bw.write(s.getDate());
            bw.write(" ");
            bw.write(s.getMethod());
            bw.write(" ");
            String s2;
            bw.write(s2 = String.valueOf((int) s.getSum()));
            bw.newLine();
        }
        bw.close();
    }
    public static Vector<sale> requestSaleData(Vector<sale> tableData) throws SQLException, ClassNotFoundException {//将数据库中的数据取出建立sale对象后存入Vector集合中
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

    public static void exportChinesePatry() throws SQLException, ClassNotFoundException, IOException {//利用字符缓冲输出流把Vector集合中的chinesepatry的各个成员变量分别写入文件chinesepatryData中
        Vector<chinesePatry> data = new Vector<>();
        data = requestChinesePatryData(data);
        BufferedWriter bw = new BufferedWriter(new FileWriter("datafile\\chinesepatryData.txt"));
        for(chinesePatry c : data){
            String s1;
            bw.write(s1 = String.valueOf(c.getId()));
            bw.write(" ");
            bw.write(c.getName());
            bw.write(" ");
            String s2;
            bw.write(s2 = String.valueOf((int) c.getPrice()));
            bw.write(" ");
            bw.write(c.getProduceDate());
            bw.write(" ");
            bw.write(c.getState());
            bw.newLine();
        }
        bw.close();
    }

    public static Vector<chinesePatry> requestChinesePatryData(Vector<chinesePatry> tableData) throws SQLException, ClassNotFoundException {//将数据库中的数据取出建立chinesepatry对象后存入Vector集合中
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

    public static void exportWesternPatry() throws SQLException, ClassNotFoundException, IOException {//利用字符缓冲输出流把Vector集合中的westernpatry的各个成员变量分别写入文件westernpatryData中
        Vector<westernPatry> data = new Vector<>();
        data = requestWesternPatryData(data);
        BufferedWriter bw = new BufferedWriter(new FileWriter("datafile\\westernpatryData.txt"));
        for(westernPatry w :data){
            String s1;
            bw.write(s1 = String.valueOf(w.getId()));
            bw.write(" ");
            bw.write(w.getName());
            bw.write(" ");
            String s2;
            bw.write(s2 = String.valueOf((int) w.getPrice()));
            bw.write(" ");
            bw.write(w.getProduceDate());
            bw.write(" ");
            bw.write(w.getState());
            bw.newLine();
        }
        bw.close();
    }

    public static Vector<westernPatry> requestWesternPatryData(Vector<westernPatry> tableData) throws SQLException, ClassNotFoundException {//将数据库中的数据取出建立westernpatry对象后存入Vector集合中
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
