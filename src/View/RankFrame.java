package View;

import ChessDao.Rank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RankFrame extends JFrame {
    public static void main(String[] args) {
        new RankFrame("qbj",20);
    }
    private JTable t_rank;
    private JLabel l_rank,l_number;
    public RankFrame(String name,int step ){
       // setUndecorated(true);

        init(name,step);
        setBounds(500,300,200,250);
        setSize(400,400);
        setVisible(true);
    }
    public void init(String name,int step){
        setLayout(null);
        Rank r = new Rank();
        r.add(name,step);
        l_rank = new JLabel("您的当前排名为：");
        l_rank.setFont(new Font("楷体",Font.BOLD,17));
        l_rank.setBounds(210,80,300,40);
        add(l_rank);
        l_number = new JLabel(""+r.rank(name,step));
        l_number.setFont(new Font("楷体",Font.BOLD,17));
        l_number.setBounds(350,100,50,40);
        add(l_number);
        Object[] title = {"昵称", "积分"};
        Rank nr = new Rank();
        Object[][] rankList = new String[nr.getPlayers().size()][2];
        for (int i = 0; i < nr.getPlayers().size(); i++) {
            for (int j = 0; j < 2; j++) {
                switch (j) {
                    case 0:
                        rankList[i][j] = nr.getPlayers().get(i).name;
                        break;
                    case 1:
                        rankList[i][j] = String.valueOf(nr.getPlayers().get(i).step);
                        break;
                }
            }
        }

        t_rank = new JTable(rankList, title);
        JScrollPane pane = new JScrollPane();
        pane.setBounds(10, 50, 200, 300);
        pane.getViewport().add(t_rank);
        t_rank.setFont(new Font("楷体", Font.CENTER_BASELINE, 15));

        this.getContentPane().add(pane);

    }
    public void paint(Graphics g){
        super.paint(g);
        ImageIcon imageIcon = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\RankView.png");
        g.drawImage(imageIcon.getImage(),60,35,100,40,null);
    }
}
