package component;

import Dao.saleDao;
import utils.screenUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class addSaleDialog extends JDialog {
    final int width = 400;
    final int height = 300;

    public addSaleDialog(JFrame jf,String title,boolean isModel){
        super(jf,title,isModel);

        this.setBounds((screenUtils.getScreenWidth()-width)/2,(screenUtils.getScreenHeight()-height)/2,width,height);

        Box vbox = Box.createVerticalBox();

        //组装订单日期box
        Box datebox = Box.createHorizontalBox();
        JLabel dateLabel = new JLabel("订单日期:");
        JTextField dateTextField = new JTextField(15);

        datebox.add(dateLabel);
        datebox.add(Box.createHorizontalStrut(20));
        datebox.add(dateTextField);

        //组装支付方式box
        Box methodbox = Box.createHorizontalBox();
        JLabel methodLabel = new JLabel("支付方式:");
        JTextField methodTextField = new JTextField(15);

        methodbox.add(methodLabel);
        methodbox.add(Box.createHorizontalStrut(20));
        methodbox.add(methodTextField);

        //组装订单总金额box
        Box sumbox = Box.createHorizontalBox();
        JLabel sumLabel = new JLabel("订单总金额:");
        JTextField sumTextField = new JTextField(15);

        sumbox.add(sumLabel);
        sumbox.add(Box.createHorizontalStrut(20));
        sumbox.add(sumTextField);

        //组装按钮box
        Box btnbox = Box.createHorizontalBox();
        JButton addbtn = new JButton("添加");

        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = dateTextField.getText().trim();
                String method = methodTextField.getText().trim();
                float sum = Float.parseFloat(sumTextField.getText().trim());

                int count;
                try {
                    count = saleDao.add(date,method,sum);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                if(count>0){
                    JOptionPane.showMessageDialog(jf,"添加成功！");
                }else{
                    JOptionPane.showMessageDialog(jf,"添加失败！");
                }
            }
        });

        btnbox.add(addbtn);

        //组装总box
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(datebox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(methodbox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(sumbox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(btnbox);

        this.add(vbox);
    }
}
