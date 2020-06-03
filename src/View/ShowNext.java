package View;

import Chess.Chess;
import Chess.ChessAlgorithm;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShowNext extends JFrame {

    public ArrayList<Point> nextPoints = ChessAlgorithm.getNextPoints(new Point(Chess.column-1,Chess.row-1));
    public void paint (Graphics g){
        super.paint(g);
        for (Point p:nextPoints) {
            ImageIcon imageIcon = new ImageIcon("src/Image/mainhorse1.png");
            g.drawImage(imageIcon.getImage(), 50 + p.x * 65, 90 + p.y * 65, 65, 65, null);
        }
    }
}
