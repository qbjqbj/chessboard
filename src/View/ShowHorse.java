package View;

import Chess.*;

import javax.swing.*;
import java.awt.*;

public class ShowHorse extends JFrame {
    public void paint(Graphics g){
        super.paint(g);
        Chess.startrow = Chess.row;
        Chess.startcolumn = Chess.column;
        ImageIcon imageIcon = new ImageIcon("src/Image/mainhorse.png");
        g.drawImage(imageIcon.getImage(),50+ (Chess.startcolumn-1)*65,90+(Chess.startrow-1)*65,65,65,null);
    }
}
