package component;

import Dao.chinesepatryDao;
import utils.screenUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class addChinesePatryDialog extends JDialog {//添加中式糕点对话框
    final int width = 400;
    final int height = 300;

    public addChinesePatryDialog(JFrame jf,String title,boolean isModel){
        super(jf,title,isModel);

        this.setBounds((screenUtils.getScreenWidth()-width)/2,(screenUtils.getScreenHeight()-height)/2,width,height);

        Box vbox = Box.createVerticalBox();

        //组装糕点名称box
        Box namebox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("糕点名称:");
        JTextField nameTextField = new JTextField(15);

        namebox.add(nameLabel);
        namebox.add(Box.createHorizontalStrut(20));
        namebox.add(nameTextField);

        //组装价格box
        Box pricebox = Box.createHorizontalBox();
        JLabel priceLabel = new JLabel("价       格:");
        JTextField priceTextField = new JTextField(15);

        pricebox.add(priceLabel);
        pricebox.add(Box.createHorizontalStrut(20));
        pricebox.add(priceTextField);

        //组装生产日期box
        Box datebox = Box.createHorizontalBox();
        JLabel dateLabel = new JLabel("生产日期:");
        JTextField dateTextField = new JTextField(15);

        datebox.add(dateLabel);
        datebox.add(Box.createHorizontalStrut(20));
        datebox.add(dateTextField);

        //组装销售状态box
        Box statebox = Box.createHorizontalBox();
        JLabel stateLabel = new JLabel("是否出售:");
        JTextField stateTextField = new JTextField(15);

        statebox.add(stateLabel);
        statebox.add(Box.createHorizontalStrut(20));
        statebox.add(stateTextField);

        //组装添加按钮
        Box btnbox = Box.createHorizontalBox();
        JButton addbtn = new JButton("添加");

        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText().trim();
                float price = Float.parseFloat(priceTextField.getText().trim());
                String produceDate = dateTextField.getText().trim();
                String state = stateTextField.getText().trim();

                int count;
                try {
                    count = chinesepatryDao.add(name,price,produceDate,state);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                if(count>0){
                    JOptionPane.showMessageDialog(jf,"添加成功！");

                }else {
                    JOptionPane.showMessageDialog(jf,"添加失败！");
                }
            }
        });

        btnbox.add(addbtn);

        //组装总box
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(namebox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(pricebox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(datebox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(statebox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(btnbox);

        this.add(vbox);
    }
}
