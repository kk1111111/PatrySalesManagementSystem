package view;

import component.chinesePatryManageComponent;
import component.promotionComponent;
import component.saleManageComponent;
import component.westernPatryManageComponent;
import utils.pathUtils;
import utils.screenUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

public class ManageGUI {
    JFrame ManageFrame = new JFrame("糕点销售系统");
    final int width = 800;
    final int height = 400;
    public void init() throws Exception {
        ManageFrame.setBounds((screenUtils.getScreenWidth()-width)/2,(screenUtils.getScreenHeight()-height)/2,width,height);
        ManageFrame.setResizable(false);

        ManageFrame.setIconImage(ImageIO.read(new File(pathUtils.getRealPath("icon2.jpg"))));

        //菜单栏制作
        JMenuBar jmb = new JMenuBar();
        JMenu setting = new JMenu("设置");
        JMenuItem handoff = new JMenuItem("切换账号");
        JMenuItem exit = new JMenuItem("退出系统");

        handoff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MainGUI().init();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                ManageFrame.dispose();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setting.add(handoff);
        setting.add(exit);
        jmb.add(setting);

        ManageFrame.setJMenuBar(jmb);

        JSplitPane jsp = new JSplitPane();

        jsp.setContinuousLayout(true);
        jsp.setDividerLocation(150);
        jsp.setDividerSize(5);

        //建立左侧面板
        DefaultMutableTreeNode system = new DefaultMutableTreeNode("系统管理");
        DefaultMutableTreeNode patry = new DefaultMutableTreeNode("糕点管理");
        DefaultMutableTreeNode chinesePatry = new DefaultMutableTreeNode("中式糕点管理");
        DefaultMutableTreeNode westernPatry = new DefaultMutableTreeNode("西式糕点管理");
        DefaultMutableTreeNode sale = new DefaultMutableTreeNode("糕点销售管理");
        DefaultMutableTreeNode promotion = new DefaultMutableTreeNode("优惠活动管理");

        patry.add(chinesePatry);
        patry.add(westernPatry);
        system.add(patry);
        system.add(sale);
        system.add(promotion);

        JTree systemTree = new JTree(system);

        MyRenderer myRenderer = new MyRenderer();
        systemTree.setCellRenderer(myRenderer);

        systemTree.setSelectionRow(1);//默认选中糕点管理
        systemTree.addTreeSelectionListener(new TreeSelectionListener() {//设置选中每个节点时右边显示的内容
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();

                if(patry.equals(lastPathComponent)){
                    jsp.setRightComponent(new JLabel("这里进行糕点管理"));
                }else if(chinesePatry.equals(lastPathComponent)){
                    try {
                        jsp.setRightComponent(new chinesePatryManageComponent(ManageFrame));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }else if(westernPatry.equals(lastPathComponent)){
                    try {
                        jsp.setRightComponent(new westernPatryManageComponent(ManageFrame));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }else if(sale.equals(lastPathComponent)){
                    try {
                        jsp.setRightComponent(new saleManageComponent(ManageFrame));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }else if(promotion.equals(lastPathComponent)){
                    jsp.setRightComponent(new promotionComponent(ManageFrame));
                }
            }
        });


        jsp.setRightComponent(new JLabel("这里进行糕点管理"));
        jsp.setLeftComponent(systemTree);
        ManageFrame.add(jsp);

        ManageFrame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new ManageGUI().init();
    }

    private class MyRenderer extends DefaultTreeCellRenderer{
        private ImageIcon systemIcon = null;
        private ImageIcon patryIcon = null;
        private ImageIcon cPatryIcon = null;
        private ImageIcon wPatryIcon = null;
        private ImageIcon saleIcon = null;
        private ImageIcon activity = null;

        public MyRenderer(){
            systemIcon = new ImageIcon(pathUtils.getRealPath("systemIcon.jpg"));
            systemIcon.setImage(systemIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
            patryIcon = new ImageIcon(pathUtils.getRealPath("patryIcon0.jpg"));
            patryIcon.setImage(patryIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
            cPatryIcon = new ImageIcon(pathUtils.getRealPath("cPatryIcon.jpg"));
            cPatryIcon.setImage(cPatryIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
            wPatryIcon = new ImageIcon(pathUtils.getRealPath("wPatryIcon.jpg"));
            wPatryIcon.setImage(wPatryIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
            saleIcon = new ImageIcon(pathUtils.getRealPath("saleIcon.jpg"));
            saleIcon.setImage(saleIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
            activity = new ImageIcon(pathUtils.getRealPath("activity.jpg"));
            activity.setImage(activity.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
        }
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            ImageIcon image = null;
            String str = value.toString();
                switch (str) {
                    case "系统管理":
                        image = systemIcon;
                        break;
                    case "糕点管理":
                        image = patryIcon;
                        break;
                    case "中式糕点管理":
                        image = cPatryIcon;
                        break;
                    case "西式糕点管理":
                        image = wPatryIcon;
                        break;
                    case "糕点销售管理":
                        image = saleIcon;
                        break;
                    case "优惠活动管理":
                        image = activity;
                        break;
                }
            this.setIcon(image);
            return this;
        }
    }
}
