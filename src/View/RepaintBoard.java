package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RepaintBoard extends JFrame {
    public void paint(Graphics g) {
        ImageIcon imageIcon = new ImageIcon("src/Image/board.jpg");
        g.drawImage(imageIcon.getImage(), 50, 90, 520, 520, null);
    }
}