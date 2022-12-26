package component;

import Dao.chinesepatryDao;
import utils.screenUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class deleteChinesePatryDialog extends JDialog {
    final int width = 400;
    final int height = 150;
    public deleteChinesePatryDialog(JFrame jf,String title,boolean isModel){
        super(jf,title,isModel);

        this.setBounds((screenUtils.getScreenWidth()-width)/2,(screenUtils.getScreenHeight()-height)/2,width,height);

        Box vbox = Box.createVerticalBox();

        //组装输入商品名称
        Box namebox = Box.createHorizontalBox();
        JLabel namelabel = new JLabel("输入要删除的商品名称:");
        JTextField nametextfield = new JTextField(15);

        namebox.add(namelabel);
        namebox.add(Box.createHorizontalStrut(10));
        namebox.add(nametextfield);

        Box btnbox = Box.createHorizontalBox();
        JButton deletebtn = new JButton("删除");

        deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nametextfield.getText().trim();
                int count2;
                try {
                    count2 = chinesepatryDao.nameDelete(name);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                if(count2>0){
                    JOptionPane.showMessageDialog(jf,"删除成功！");
                }else {
                    JOptionPane.showMessageDialog(jf,"添加失败！");
                }
            }
        });

        btnbox.add(deletebtn);

        vbox.add(Box.createVerticalStrut(20));
        vbox.add(namebox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(btnbox);

        this.add(vbox);
    }
}
