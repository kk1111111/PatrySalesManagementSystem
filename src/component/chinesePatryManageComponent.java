package component;

import Dao.chinesepatryDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

public class chinesePatryManageComponent extends Box {
    final int width = 600;
    final int height = 300;

    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private TableModel tableModel;

    public chinesePatryManageComponent() throws SQLException, ClassNotFoundException {
        super(BoxLayout.Y_AXIS);

        JPanel btnPanel = new JPanel();
        btnPanel.setMaximumSize(new Dimension(width,50));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addButton = new JButton("增加");
        JButton deleteButton = new JButton("删除");
        JButton searchButton = new JButton("查询");
        JButton updateButton = new JButton("修改");

        btnPanel.add(addButton);
        btnPanel.add(deleteButton);
        btnPanel.add(searchButton);
        btnPanel.add(updateButton);

        this.add(btnPanel);

        //组装表格
        String[] ts = {"编号","糕点名称","价格","生产日期","是否出售"};
        titles = new Vector<>();
        for (String title : ts){
            titles.add(title);
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
        ResultSet rs = chinesepatryDao.selectAll();
        Vector chinesepatry = null;
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            Date produceDate = rs.getDate("produceDate");
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
