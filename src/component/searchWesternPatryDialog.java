package component;

import utils.screenUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class searchWesternPatryDialog extends JDialog {
    final int width = 400;
    final int height = 150;

    public searchWesternPatryDialog(JFrame jf, String title, boolean isModel) {
        super(jf, title, isModel);

        this.setBounds((screenUtils.getScreenWidth() - width) / 2, (screenUtils.getScreenHeight() - height) / 2, width, height);

        Box vbox = Box.createVerticalBox();

        Box namebox = Box.createHorizontalBox();
        JLabel namelabel = new JLabel("请输入要查询的商品名称:");
        JTextField nametextfield = new JTextField(15);

        namebox.add(namelabel);
        namebox.add(Box.createHorizontalStrut(10));
        namebox.add(nametextfield);

        Box btnbox = Box.createHorizontalBox();
        JButton searchbtn = new JButton("查询");

        searchbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nametextfield.getText().trim();
                try {
                    new searchWesternPatryComponent(jf,"查询结果为:",true,name).setVisible(true);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnbox.add(searchbtn);

        vbox.add(Box.createVerticalStrut(20));
        vbox.add(namebox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(btnbox);

        this.add(vbox);
    }
}