package view;

import Dao.accountDao;
import component.BackgroundPanel;
import utils.pathUtils;
import utils.screenUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class MainGUI {//登录界面，所有界面的入口
    JFrame mainframe = new JFrame("糕点店销售系统");
    final int width = 600;
    final int heigt = 300;
    public void init() throws Exception {
        mainframe.setBounds((screenUtils.getScreenWidth()-width)/2,(screenUtils.getScreenHeight()-heigt)/2,width,heigt);
        mainframe.setResizable(false);
        mainframe.setIconImage(ImageIO.read(new File(pathUtils.getRealPath("icon2.jpg"))));
        //设置背景
        BackgroundPanel BG = new BackgroundPanel(ImageIO.read(new File(pathUtils.getRealPath("back2.jpg"))));
        //组装总box
        Box loginBox = Box.createVerticalBox();
        Font font = new Font("宋体",Font.PLAIN,25);

        //组装用户名box
        Box userBox = Box.createHorizontalBox();
        JLabel userLabel = new JLabel("用户名：");
        JTextField userTextField = new JTextField(15);

        userLabel.setFont(font);
        userLabel.setForeground(Color.green);
        userBox.add(userLabel);
        userBox.add(Box.createHorizontalStrut(20));
        userBox.add(userTextField);

        //组装密码box
        Box passwordBox = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("密  码：");
        JTextField passwordTextField = new JTextField(15);

        passwordLabel.setFont(font);
        passwordLabel.setForeground(Color.green);
        passwordBox.add(passwordLabel);
        passwordBox.add(Box.createHorizontalStrut(20));
        passwordBox.add(passwordTextField);

        //组装注册登录box
        Box buttonbox = Box.createHorizontalBox();
        JButton registButton = new JButton("注册");
        JButton loginButton = new JButton("登录");

        registButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new RegisterGUI().init();//跳转到注册界面
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                mainframe.dispose();//登录界面关闭
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userTextField.getText().trim();
                String password = passwordTextField.getText().trim();

                int count;

                try {
                    count = accountDao.checkAccount(username,password);//检查是否存在这组账号密码
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                if(count>0){
                    JOptionPane.showMessageDialog(mainframe,"登录成功！");
                    try {
                        new ManageGUI().init();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    mainframe.dispose();
                }else{
                    JOptionPane.showMessageDialog(mainframe,"登录失败！");
                    userTextField.setText("");
                    passwordTextField.setText("");
                }

            }
        });


        buttonbox.add(registButton);
        buttonbox.add(Box.createHorizontalStrut(80));
        buttonbox.add(loginButton);

        //把userbox,passwordbox,buttonbox组装到总box
        loginBox.add(Box.createVerticalStrut(50));
        loginBox.add(userBox);
        loginBox.add(Box.createVerticalStrut(20));
        loginBox.add(passwordBox);
        loginBox.add(Box.createVerticalStrut(40));
        loginBox.add(buttonbox);

        BG.add(loginBox);
        mainframe.add(BG);

        mainframe.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MainGUI().init();
    }
}
