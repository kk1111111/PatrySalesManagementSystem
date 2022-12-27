package component;

import utils.screenUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class searchSaleDialog extends JDialog {
    final int width = 400;
    final int height = 150;

    public searchSaleDialog(JFrame jf,String title,boolean isModel){
        super(jf,title,isModel);

        this.setBounds((screenUtils.getScreenWidth()-width)/2,(screenUtils.getScreenHeight()-height)/2,width,height);

        Box vbox = Box.createVerticalBox();

        Box datebox = Box.createHorizontalBox();
        JLabel datelabel = new JLabel("请输入要查询的日期:");
        JTextField datetextfield = new JTextField(15);

        datebox.add(datelabel);
        datebox.add(Box.createHorizontalStrut(10));
        datebox.add(datetextfield);

        Box btnbox = Box.createHorizontalBox();
        JButton searchbtn = new JButton("查询");

        searchbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = datetextfield.getText().trim();
                try {
                    new searchSaleComponent(jf,"查询结果为:",true,date).setVisible(true);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnbox.add(searchbtn);

        vbox.add(Box.createVerticalStrut(20));
        vbox.add(datebox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(btnbox);

        this.add(vbox);
    }
}
