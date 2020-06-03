package View;

import Chess.*;
import ChessDao.MouseShowHoard;
import ChessDao.Rank;
import Servise.AboutGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    public static void main(String[] args) {
     new MainFrame();
    }
    public int start1=0,start2=0,play = 0;
    public static int row;
    public static int column;
    private JPanel jp;
    public static JLabel l_number;
    private JLabel l_game;
    private JTextField t_row,t_column;
    private JButton b_rank,b_row,b_column,b_robot,b_about,b_music,b_ragain,b_again,b_dispose;
    public MainFrame(){
        setUndecorated(true);
        setBounds(300, 70, 920,660);
        this.validate();
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
                int column_x = e.getX();
                int row_y = e.getY();
                if(column_x>50&&column_x<570&&row_y>90&&row_y<610){
                System.out.println("qbj");
                System.out.println(ChessAlgorithm.getNextPoints(new Point(Chess.column-1,Chess.row-1)));
                new MouseShowHoard((column_x-50)/65,(row_y-90)/65);
                ShowNextHorse nh = new ShowNextHorse();
                nh.paint(getGraphics());
            }
        }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                setLocation((e.getXOnScreen() - mouseAtX[0]), (e.getYOnScreen() - mouseAtY[0]));//设置拖拽后，窗口的位置
            }
        });
        l_game = new JLabel();
        Icon icon = new ImageIcon("src/Image/game.png");
        l_game.setBounds(550,10,400,80);
        l_game.setIcon(icon);
        add(l_game);
        t_row = new JTextField("");
        t_row.setFont(new Font("楷体",Font.BOLD,15));
        t_row.setBounds(820,110,40,40);
        add(t_row);
        ImageIcon imageIcon1 = new ImageIcon("src/Image/row.png");
        b_row = new JButton();
        b_row.setIcon(imageIcon1);
        b_row.setBounds(650,110,140,38);
        b_row.setBorderPainted(false);
        add(b_row);
        t_column = new JTextField("");
        t_column.setFont(new Font("楷体",Font.BOLD,15));
        t_column.setBounds(820,170,40,40);
        add(t_column);
        ImageIcon imageIcon4 = new ImageIcon("src/Image/column.png");
        b_column = new JButton();
        b_column.setIcon(imageIcon4);
        b_column.setBounds(650,170,140,40);
        b_column.setBorderPainted(false);
        add(b_column);
        ImageIcon imageIcon9 = new ImageIcon("src/Image/again.png");
        b_again = new JButton();
        b_again.setIcon(imageIcon9);
        b_again.setBounds(650,240,140,40);
        b_again.setBorderPainted(false);
        add(b_again);
        ImageIcon imageIcon5 = new ImageIcon("src/Image/robot.png");
        b_robot = new JButton();
        b_robot.setIcon(imageIcon5);
        b_robot.setBounds(650,305,140,40);
        b_robot.setBorderPainted(false);
        add(b_robot);
        ImageIcon imageIcon7 = new ImageIcon("src/Image/ragain.png");
        b_ragain = new JButton();
        b_ragain.setIcon(imageIcon7);
        b_ragain.setBounds(650,375,140,43);
        b_ragain.setBorderPainted(false);
        add(b_ragain);
        ImageIcon imageIcon6 = new ImageIcon("src/Image/about.png");
        b_about = new JButton();
        b_about.setIcon(imageIcon6);
        b_about.setBounds(650,500,140,45);
        b_about.setBorderPainted(false);
        add(b_about);
        ImageIcon imageIcon10 = new ImageIcon("src/Image/dispose.png");
        b_dispose = new JButton();
        b_dispose.setIcon(imageIcon10);
        b_dispose.setBounds(885,0,35,37);
        b_dispose.setBorderPainted(false);
        add(b_dispose);
        jp = new JPanel();
        jp.setBackground(Color.gray);
        jp.setBounds(0,0,920,700);
        jp.validate();
        add(jp);
        ImageIcon imageIcon = new ImageIcon("src/Image/rank.png");
        b_rank = new JButton(imageIcon);
        this.add(b_rank);
        b_rank.setBounds(650,560,140,45);
        b_rank.setBorderPainted(false);
        b_rank.setVisible(true);
        jButtonObserve();
    }
    public void paint(Graphics g){
        super.paint(g);
        ImageIcon imageIcon1 = new ImageIcon("src/Image/board.jpg");
        ImageIcon imageIcon2 = new ImageIcon("src/Image/number.png");
        g.drawImage(imageIcon1.getImage(),50,90,520,520,null);
        g.drawImage(imageIcon2.getImage(),60,25,50,50,null);
        g.drawImage(imageIcon2.getImage(),120,25,50,50,null);
        g.drawImage(imageIcon2.getImage(),180,25,50,50,null);
        g.drawImage(imageIcon2.getImage(),240,25,50,50,null);
        g.drawImage(imageIcon2.getImage(),300,25,50,50,null);
        g.drawImage(imageIcon2.getImage(),360,25,50,50,null);
        g.drawImage(imageIcon2.getImage(),420,25,50,50,null);
        g.drawImage(imageIcon2.getImage(),480,25,50,50,null);
        g.drawImage(imageIcon2.getImage(),580,100,50,50,null);
        g.drawImage(imageIcon2.getImage(),580,170,50,50,null);
        g.drawImage(imageIcon2.getImage(),580,240,50,50,null);
        g.drawImage(imageIcon2.getImage(),580,310,50,50,null);
        g.drawImage(imageIcon2.getImage(),580,380,50,50,null);
        //g.drawImage(imageIcon2.getImage(),580,450,50,50,null);
        g.drawImage(imageIcon2.getImage(),580,490,50,50,null);
        g.drawImage(imageIcon2.getImage(),580,560,50,50,null);
        g.drawLine(570,460,940,460);
    }
    public void jButtonObserve(){
        b_rank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new RankFrame1();
            }
        });
        b_dispose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        b_about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AboutGame();
            }
        });
        b_ragain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RepaintBoard r = new RepaintBoard();
                r.paint(getGraphics());
                t_row.setText("");
                t_column.setText("");
                Chess.step = 0;
                Chess.column = -1;
                Chess.row = -1;
                for(int i = 0;i<Chess.visited.length;i++){
                    Chess.visited[i] = false;
                }
                JOptionPane.showMessageDialog(null,"已为您清空棋盘,马初始行,马初始列","提示",JOptionPane.PLAIN_MESSAGE);
            }
        });
        b_robot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SureFrame();
            }
        });
        b_again.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if((start1 == 1)&&(start2 == 1)){
                    play = 1;
                    Chess.visited[(Chess.row-1)*8+(column-1)] = true;
                    JOptionPane.showMessageDialog(null,"开始挑战！","提示",JOptionPane.PLAIN_MESSAGE);
                    RepaintBoard r = new RepaintBoard();
                    r.paint(getGraphics());
                    ShowHorse sh = new ShowHorse();
                    sh.paint(getGraphics());
                    ShowNext sn = new ShowNext();
                    sn.paint(getGraphics());
                    //ChessAlgorithm.traversalChessboard(ChessAlgorithm.chessboard,Chess.row-1,Chess.column-1,1);
                }else{
                    JOptionPane.showMessageDialog(null,"请设置正确的马的初始位置","提示",JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        b_column.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(t_column.getText()!=null&& Rank.isNumber(t_column.getText())){
                    if((Integer.valueOf(t_column.getText())>0)&&(Integer.valueOf(t_column.getText())<9)){
                        JOptionPane.showMessageDialog(null,"马的初始列位置为"+Integer.valueOf(t_column.getText()),"提示",JOptionPane.PLAIN_MESSAGE);
                        Chess.column = Integer.valueOf(t_column.getText());
                        column = Chess.column;
                        System.out.println(Chess.column);
                        start2 = 1;
                    }else{
                        JOptionPane.showMessageDialog(null,"请输入正确的初始列数","提示",JOptionPane.PLAIN_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"请输入1-8的马的初始列数,是整数噢！","提示",JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        b_row.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(t_row.getText()!=null&& Rank.isNumber(t_row.getText())){
                    if((Integer.valueOf(t_row.getText())>0)&&(Integer.valueOf(t_row.getText())<9)){
                        JOptionPane.showMessageDialog(null,"马的初始行位置为"+Integer.valueOf(t_row.getText()),"提示",JOptionPane.PLAIN_MESSAGE);
                        Chess.row = Integer.valueOf(t_row.getText());
                        row = Chess.row;
                        System.out.println(Chess.row);
                        start1 = 1;
                    }else{
                        JOptionPane.showMessageDialog(null,"请输入正确的初始行数","提示",JOptionPane.PLAIN_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"请输入1-8的马的初始列数，是整数啊","提示",JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

    }

}
