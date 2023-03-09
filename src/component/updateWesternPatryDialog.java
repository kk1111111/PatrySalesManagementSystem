package component;

import Dao.westernpatryDao;
import utils.screenUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class updateWesternPatryDialog extends JDialog {//修改西式糕点价格对话框
    final int width = 400;
    final int height = 200;

    public updateWesternPatryDialog(JFrame jf,String title,boolean isModel){
        super(jf,title,isModel);

        this.setBounds((screenUtils.getScreenWidth()-width)/2,(screenUtils.getScreenHeight()-height)/2,width,height);

        Box vbox = Box.createVerticalBox();

        //组装输入商品名称
        Box namebox = Box.createHorizontalBox();
        JLabel namelabel = new JLabel("输入要修改的商品名称:");
        JTextField nametextfield = new JTextField(15);

        namebox.add(namelabel);
        namebox.add(Box.createHorizontalStrut(10));
        namebox.add(nametextfield);

        //组装输入价格
        Box pricebox = Box.createHorizontalBox();
        JLabel pricelabel = new JLabel("输   入   新   价   格:");
        JTextField pricetextfield = new JTextField(15);

        pricebox.add(pricelabel);
        pricebox.add(Box.createHorizontalStrut(10));
        pricebox.add(pricetextfield);

        Box btnbox = Box.createHorizontalBox();
        JButton updatebtn = new JButton("修改");

        updatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nametextfield.getText().trim();
                float newprice = Float.parseFloat(pricetextfield.getText().trim());
                int count;
                try {
                    count = westernpatryDao.priceUpdate(name,newprice);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                if(count>0){
                    JOptionPane.showMessageDialog(jf,"修改成功！");
                }else {
                    JOptionPane.showMessageDialog(jf,"修改失败！");
                }
            }
        });

        btnbox.add(updatebtn);

        vbox.add(Box.createVerticalStrut(20));
        vbox.add(namebox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(pricebox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(btnbox);

        this.add(vbox);
    }
}
