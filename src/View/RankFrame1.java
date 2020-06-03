package View;

import ChessDao.Rank;

import javax.swing.*;
import java.awt.*;

public class RankFrame1 extends JFrame{
    public static void main(String[] args) {
        new RankFrame1();
    }
    private JTable t_rank;

    public RankFrame1( ){
        setVisible(true);
        init();
        setBounds(500,300,230,450);
        setSize(230,450);
    }
    public void init(){
        setLayout(null);
        Rank r = new Rank();
        Object[] title = {"昵称", "积分"};
        Object[][] rankList = new String[r.getPlayers().size()][2];
        for (int i = 0; i < r.getPlayers().size(); i++) {
            for (int j = 0; j < 2; j++) {
                switch (j) {
                    case 0:
                        rankList[i][j] = r.getPlayers().get(i).name;
                        break;
                    case 1:
                        rankList[i][j] = String.valueOf(r.getPlayers().get(i).step);
                        break;
                }
            }
        }

        t_rank = new JTable(rankList, title);
        JScrollPane pane = new JScrollPane();
        pane.setBounds(10, 65, 200, 300);
        pane.getViewport().add(t_rank);
        t_rank.setFont(new Font("楷体", Font.CENTER_BASELINE, 15));

        this.getContentPane().add(pane);

    }
    public void paint(Graphics g){
        super.paint(g);
        ImageIcon imageIcon = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\RankView.png");
        g.drawImage(imageIcon.getImage(),60,40,100,40,null);
    }
}

