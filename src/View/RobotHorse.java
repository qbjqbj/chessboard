package View;

import Chess.*;
import javafx.concurrent.ScheduledService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RobotHorse extends JFrame {

    public void paint(Graphics g){
        int step = 1;
        Chess.column = Chess.startcolumn;
        Chess.row = Chess.startrow;
        super.paint(g);
            //ChessAlgorithm.getRoute();
            ChessAlgorithm.traversalChessboard(ChessAlgorithm.chessboard, Chess.row - 1, Chess.column - 1, 1);
            for(int j = 0;j<ChessAlgorithm.chessboard.length;j++) {
                Chess.visited[(Chess.row-1)*8+(Chess.column-1)] = true;
                for(int n = 0;n<ChessAlgorithm.step.length;n++){
                    if(step == ChessAlgorithm.step[n]){

                        Chess.row = n/8+1;
                        Chess.column = n%8+1;
                        ArrayList<Point> nextPoints = ChessAlgorithm.getNextPoints(new Point(Chess.column - 1, Chess.row - 1));
                        ImageIcon imageIcon = new ImageIcon("src/Image/board.jpg");
                        g.drawImage(imageIcon.getImage(), 50, 90, 520, 520, null);
                        for (int i = 0; i < Chess.visited.length; i++) {
                            if (Chess.visited[i] == true) {
                                ImageIcon imageIcon4 = new ImageIcon("src/Image/runhorse.png");
                                g.drawImage(imageIcon4.getImage(), 50 + (i % 8) * 65, 90 + (i / 8) * 65, 65, 65, null);
                            }
                        }
                        ImageIcon imageIcon1 = new ImageIcon("src/Image/mainhorse.png");
                        g.drawImage(imageIcon1.getImage(), 50 + (Chess.column - 1) * 65, 90 + (Chess.row - 1) * 65, 65, 65, null);
                        for (Point p : nextPoints) {
                            ImageIcon imageIcon2 = new ImageIcon("src/Image/mainhorse1.png");
                            g.drawImage(imageIcon2.getImage(), 50 + p.x * 65, 90 + p.y * 65, 65, 65, null);
                        }
                        step++;
                    }
                }
            }
        }
    }
