package component;

import Dao.promotionDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class promotionComponent extends Box {

    JFrame jf = null;
    public promotionComponent(JFrame jf) {
        super(BoxLayout.Y_AXIS);

        this.jf=jf;

        Box vbox = Box.createVerticalBox();

        //组装中式糕点活动按钮及其取消按钮box
        Box btnbox1 = Box.createHorizontalBox();
        JButton btnP1 = new JButton("中式糕点全场8折");
        JButton btnB1 = new JButton("活动取消");

        btnP1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count;
                try {
                    count=promotionDao.chinesepatryP();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                btnP1.setEnabled(false);
                if(count>0){
                    JOptionPane.showMessageDialog(jf,"活动设置成功！");
                }else{
                    JOptionPane.showMessageDialog(jf,"活动设置失败！");
                }
            }
        });

        btnB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count;
                try {
                    count=promotionDao.back1();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                btnB1.setEnabled(false);
                if(count>0){
                    JOptionPane.showMessageDialog(jf,"活动取消成功！");
                }else{
                    JOptionPane.showMessageDialog(jf,"活动取消失败！");
                }
            }
        });

        btnbox1.add(btnP1);
        btnbox1.add(Box.createHorizontalStrut(20));
        btnbox1.add(btnB1);

        //组装西式糕点活动按钮及其取消按钮box
        Box btnbox2 = Box.createHorizontalBox();
        JButton btnP2 = new JButton("西式糕点全场8折");
        JButton btnB2 = new JButton("活动取消");

        btnP2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count;
                try {
                    count=promotionDao.westernpatryP();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                btnP2.setEnabled(false);
                if(count>0){
                    JOptionPane.showMessageDialog(jf,"活动设置成功！");
                }else{
                    JOptionPane.showMessageDialog(jf,"活动设置失败！");
                }
            }
        });

        btnB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count;
                try {
                    count=promotionDao.back2();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                btnB2.setEnabled(false);
                if(count>0){
                    JOptionPane.showMessageDialog(jf,"活动取消成功！");
                }else{
                    JOptionPane.showMessageDialog(jf,"活动取消失败！");
                }
            }
        });

        btnbox2.add(btnP2);
        btnbox2.add(Box.createHorizontalStrut(20));
        btnbox2.add(btnB2);

        //组装所有糕点活动按钮及其取消按钮box
        Box btnbox3 = Box.createHorizontalBox();
        JButton btnP3 = new JButton("所有糕点全场8折");
        JButton btnB3 = new JButton("活动取消");

        btnP3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count;
                try {
                    count=promotionDao.patryP();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                btnP3.setEnabled(false);
                if(count>1){
                    JOptionPane.showMessageDialog(jf,"活动设置成功！");
                }else{
                    JOptionPane.showMessageDialog(jf,"活动设置失败！");
                }
            }
        });

        btnB3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count;
                try {
                    count=promotionDao.back3();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                btnB3.setEnabled(false);
                if(count>1){
                    JOptionPane.showMessageDialog(jf,"活动取消成功！");
                }else{
                    JOptionPane.showMessageDialog(jf,"活动取消失败！");
                }
            }
        });

        btnbox3.add(btnP3);
        btnbox3.add(Box.createHorizontalStrut(20));
        btnbox3.add(btnB3);

        vbox.add(Box.createVerticalStrut(50));
        vbox.add(btnbox1);
        vbox.add(Box.createVerticalStrut(50));
        vbox.add(btnbox2);
        vbox.add(Box.createVerticalStrut(50));
        vbox.add(btnbox3);
        vbox.add(Box.createVerticalStrut(50));

        this.add(vbox);
    }
}
