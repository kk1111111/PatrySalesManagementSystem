package component;

import Dao.saleDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class saleManageComponent extends Box {
    final int width = 600;
    final int height = 300;

    JFrame jf = null;
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private TableModel tableModel;

    public saleManageComponent(JFrame jf) throws SQLException, ClassNotFoundException {
        super(BoxLayout.Y_AXIS);

        this.jf = jf;
        JPanel btnPanel = new JPanel();
        btnPanel.setMaximumSize(new Dimension(width,50));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addButton = new JButton("增加");
        JButton searchButton = new JButton("查询");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addSaleDialog(jf,"添加销售订单",true).setVisible(true);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new searchSaleDialog(jf,"查询某日的订单",true).setVisible(true);
            }
        });

        btnPanel.add(addButton);
        btnPanel.add(searchButton);

        this.add(btnPanel);

        //组装表格
        String[] ts = {"编号","订单日期","支付方式","订单总金额"};
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
        ResultSet rs = saleDao.selectAll();
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
