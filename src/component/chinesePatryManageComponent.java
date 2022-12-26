package component;

import Dao.chinesepatryDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

public class chinesePatryManageComponent extends Box {
    final int width = 600;
    final int height = 300;

    JFrame jf = null;
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private TableModel tableModel;

    public chinesePatryManageComponent(JFrame jf) throws SQLException, ClassNotFoundException {
        super(BoxLayout.Y_AXIS);

        this.jf = jf;
        JPanel btnPanel = new JPanel();
        btnPanel.setMaximumSize(new Dimension(width,50));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addButton = new JButton("增加");
        JButton deleteButton = new JButton("删除");
        JButton searchButton = new JButton("查询");
        JButton updateButton = new JButton("修改");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addChinesePatryDialog(jf,"添加中式糕点",true).setVisible(true);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new deleteChinesePatryDialog(jf,"删除中式糕点",true).setVisible(true);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new updateChinesePatryDialog(jf,"修改中式糕点价格",true).setVisible(true);
            }
        });

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
