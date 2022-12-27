package component;

import Dao.saleDao;
import utils.screenUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class searchSaleComponent extends JDialog {
    final int width = 600;
    final int height = 300;

    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private TableModel tableModel;

    public searchSaleComponent(JFrame jf,String title,boolean isModel,String date) throws SQLException, ClassNotFoundException {
        super(jf,title,isModel);

        this.setBounds((screenUtils.getScreenWidth()-width)/2,(screenUtils.getScreenHeight()-height)/2,width,height);

        //组装表格
        String[] ts = {"编号","订单日期","支付方式","订单总金额"};
        titles = new Vector<>();
        for (String title1 : ts){
            titles.add(title1);
        }

        tableData = new Vector<>();

        requestData(tableData,date);

        tableModel = new DefaultTableModel(tableData,titles);
        table = new JTable(tableModel){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
    }

    public Vector<Vector> requestData(Vector<Vector> tableData,String date1) throws SQLException, ClassNotFoundException {
        ResultSet rs = saleDao.search(date1);
        Vector sale = null;
        while(rs.next()){
            int id = rs.getInt("id");
            String date = rs.getString("date");
            String method = rs.getString("method");
            float sum = rs.getFloat("sum");

            sale = new Vector();
            sale.add(id);
            sale.add(date);
            sale.add(method);
            sale.add(sum);

            tableData.add(sale);
        }
        return tableData;
    }
}
