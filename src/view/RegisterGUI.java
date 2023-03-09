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

public class RegisterGUI {//注册界面
    JFrame registerFrame = new JFrame("注册");

    final int width = 600;
    final int height =300;

    public void init() throws Exception {
        registerFrame.setBounds((screenUtils.getScreenWidth()-width)/2,(screenUtils.getScreenHeight()-height)/2,width,height);
        registerFrame.setResizable(false);
        registerFrame.setIconImage(ImageIO.read(new File(pathUtils.getRealPath("icon2.jpg"))));

        //设置注册界面的背景
        BackgroundPanel registerBG = new BackgroundPanel(ImageIO.read(new File(pathUtils.getRealPath("back2.jpg"))));

        //总box
        Box registerBox = Box.createVerticalBox();
        Font font = new Font("宋体",Font.PLAIN,25);

        //用户名box
        Box rUserBox = Box.createHorizontalBox();
        JLabel rUserLabel = new JLabel("请输入用户名：");
        JTextField rUserTextField = new JTextField(15);

        rUserLabel.setFont(font);
        rUserLabel.setForeground(Color.green);
        rUserBox.add(rUserLabel);
        rUserBox.add(Box.createVerticalStrut(20));
        rUserBox.add(rUserTextField);

        //密码box
        Box rPasswordBox = Box.createHorizontalBox();
        JLabel rPasswordLabel = new JLabel("请输入密码：");
        JTextField rPasswordTextField = new JTextField(15);

        rPasswordLabel.setFont(font);
        rPasswordLabel.setForeground(Color.green);
        rPasswordBox.add(rPasswordLabel);
        rPasswordBox.add(Box.createVerticalStrut(20));
        rPasswordBox.add(rPasswordTextField);

        //按钮box
        Box btnBox = Box.createHorizontalBox();
        JButton registerButton = new JButton("注册");
        JButton backButton = new JButton("返回登录界面");

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = rUserTextField.getText().trim();
                String password = rPasswordTextField.getText().trim();
                if (username.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(registerFrame, "用户名或者密码不能为空！");
                } else {
                    int count;
                    try {
                        count = accountDao.addAccount(username, password);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (count > 0) {
                        JOptionPane.showMessageDialog(registerFrame, "注册成功！");
                        try {
                            new MainGUI().init();
                            registerFrame.dispose();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(registerFrame, "注册失败！");
                        try {
                            new MainGUI().init();
                            registerFrame.dispose();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MainGUI().init();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                registerFrame.dispose();
            }
        });

        btnBox.add(registerButton);
        btnBox.add(Box.createHorizontalStrut(40));
        btnBox.add(backButton);

        //把rUserBox,rPasswordBox,btnBox组装到总box
        registerBox.add(Box.createVerticalStrut(50));
        registerBox.add(rUserBox);
        registerBox.add(Box.createVerticalStrut(20));
        registerBox.add(rPasswordBox);
        registerBox.add(Box.createVerticalStrut(20));
        registerBox.add(btnBox);

        registerBG.add(registerBox);

        registerFrame.add(registerBG);

        registerFrame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new RegisterGUI().init();
    }
}
