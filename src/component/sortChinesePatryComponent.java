package component;

import Dao.chinesepatryDao;
import utils.screenUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class sortChinesePatryComponent extends JDialog {//显示中式糕点排序结果的界面
    final int width = 400;
    final int height = 150;

    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private TableModel tableModel;

    public sortChinesePatryComponent(JFrame jf,String title,boolean isModel) throws SQLException, ClassNotFoundException {
        super(jf, title,isModel);

        this.setBounds((screenUtils.getScreenWidth()-width)/2,(screenUtils.getScreenHeight()-height)/2,width,height);

        String[] ts = {"编号","糕点名称","价格","生产日期","是否出售"};
        titles = new Vector<>();
        for (String title1 : ts){
            titles.add(title1);
        }

        tableData = new Vector<>();

        requestData(tableData);

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

    public Vector<Vector> requestData(Vector<Vector> tableData) throws SQLException, ClassNotFoundException {
        ResultSet rs = chinesepatryDao.sort();
        Vector chinesepatry = null;
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            String produceDate = rs.getString("produceDate");
            String state = rs.getString("state");

            chinesepatry = new Vector();
            chinesepatry.add(id);
            chinesepatry.add(name);
            chinesepatry.add(price);
            chinesepatry.add(produceDate);
            chinesepatry.add(state);

            tableData.add(chinesepatry);
        }
        return tableData;
    }
}
