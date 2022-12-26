package component;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image backIcon;
    public BackgroundPanel(Image backIcon){
        this.backIcon = backIcon;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backIcon,0,0,this.getWidth(),this.getHeight(),null);
    }
}
