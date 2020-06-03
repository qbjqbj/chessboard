package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardFrame extends JFrame{
    public static void main(String[] args) {
     new BoardFrame();
    }
    private JPanel left,right;
    private JLabel l_cha,l_intro,l_row,l_column;
    private JButton b_pai,b_row,b_column,b_robot,b_about,b_music,b_ragain,b_again,b_dispose;
    private JLabel l3;
    public BoardFrame(){

        setUndecorated(true);
        setBounds(300, 70, 800, 620);
        init();
        setVisible(true);

    }

    public void init() {
        setLayout(null);
        final int[] mouseAtX = new int[1];
        final int[] mouseAtY = new int[1];
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                /*
                 * 获取点击鼠标时的坐标
                 */
                mouseAtX[0] = e.getPoint().x;
                mouseAtY[0] = e.getPoint().y;
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                setLocation((e.getXOnScreen() - mouseAtX[0]), (e.getYOnScreen() - mouseAtY[0]));//设置拖拽后，窗口的位置
            }
        });

        ImageIcon imageIcon1 = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\row.png");
        b_row = new JButton();
        b_row.setIcon(imageIcon1);
        b_row.setBounds(570,120,140,38);
        b_row.setBorderPainted(false);
        add(b_row);
        ImageIcon imageIcon4 = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\column.png");
        b_column = new JButton();
        b_column.setIcon(imageIcon4);
        b_column.setBounds(570,190,140,40);
        b_column.setBorderPainted(false);
        add(b_column);
        ImageIcon imageIcon9 = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\again.png");
        b_again = new JButton();
        b_again.setIcon(imageIcon9);
        b_again.setBounds(570,260,140,40);
        b_again.setBorderPainted(false);
        add(b_again);
        ImageIcon imageIcon5 = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\robot.png");
        b_robot = new JButton();
        b_robot.setIcon(imageIcon5);
        b_robot.setBounds(570,330,140,40);
        b_robot.setBorderPainted(false);
        add(b_robot);

        ImageIcon imageIcon7 = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\ragain.png");
        b_ragain = new JButton();
        b_ragain.setIcon(imageIcon7);
        b_ragain.setBounds(570,395,140,43);
        b_ragain.setBorderPainted(false);
        add(b_ragain);
        ImageIcon imageIcon8 = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\music.png");
        b_music = new JButton();
        b_music.setIcon(imageIcon8);
        b_music.setBounds(570,460,140,45);
        b_music.setBorderPainted(false);
        add(b_music);
        ImageIcon imageIcon6 = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\about.png");
        b_about = new JButton();
        b_about.setIcon(imageIcon6);
        b_about.setBounds(570,530,140,45);
        b_about.setBorderPainted(false);
        add(b_about);
        ImageIcon imageIcon10 = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\dispose.png");
        b_dispose = new JButton();
        b_dispose.setIcon(imageIcon10);
        b_dispose.setBounds(765,0,35,37);
        b_dispose.setBorderPainted(false);
        b_dispose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        add(b_dispose);
        right = new JPanel();
        right.setBounds(539,0,263,700);
        right.setBackground(Color.gray);
        add(right);
       left = new JPanel();
        left.setBackground(Color.gray);
        left.setBounds(0,0,540,700);
        add(left);
        b_pai = new JButton();
        ImageIcon imageIcon = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\rank.png");
        b_pai.setIcon(imageIcon);
        b_pai.setBounds(510,25,238,70);
        b_pai.setBorderPainted(false);
        add(b_pai);
        b_pai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new RankFrame1();
            }
        });


        l_column = new JLabel();

    }
    public void paint(Graphics g){
        super.paint(g);
        ImageIcon imageIcon1 = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\board.jpg");
        ImageIcon imageIcon2 = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\number.png");
        ImageIcon imageIcon3 = new ImageIcon("Y:\\马踏棋盘\\src\\Image\\cha.png");
        g.drawImage(imageIcon1.getImage(),50,115,450,450,null);
        g.drawImage(imageIcon2.getImage(),50,30,80,60,null);
        g.drawImage(imageIcon3.getImage(),130,35,50,50,null);
    }
}