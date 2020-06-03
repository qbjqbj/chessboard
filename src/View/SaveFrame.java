package View;

import Chess.Chess;
import ChessDao.Rank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveFrame extends JFrame {
    public static void main(String[] args) {
        new SaveFrame();
    }
    private JLabel l_1,l_2,l_3;
    private JTextField t_1;
    private JButton b_1,b_2;
    public SaveFrame(){
        setVisible(true);
        setTitle("马踏棋盘！");
        init();
        setBounds(500,250,300,300);
    }
    public void init(){
        setLayout(null);
        l_1 = new JLabel("游戏结束，您一共走了"+ Chess.step +"步");
        l_1.setFont(new Font("楷体",Font.BOLD,17));
        l_1.setBounds(7,10,270,40);
        add(l_1);
        l_2 = new JLabel("(请输入您的昵称并且将记录到排行榜)");
        l_2.setFont(new Font("楷体",Font.BOLD,15));
        l_2.setBounds(7,50,300,40);
        add(l_2);
        t_1 = new JTextField();
        t_1.setBounds(90,100,100,40);
        t_1.setFont(new Font("楷体",Font.BOLD,20));
        add(t_1);
        l_3 = new JLabel("昵称");
        l_3.setFont(new Font("楷体",Font.BOLD,20));
        l_3.setBounds(30,100,50,40);
        add(l_3);
        b_1 = new JButton("我要上榜！");
        b_1.setFont(new Font("楷体",Font.BOLD,15));
        b_1.setBounds(15,170,120,30);
        add(b_1);
        b_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Rank r = new Rank();
                if(r.findname(t_1.getText())){
                    JOptionPane.showMessageDialog(null,"恭喜您上榜成功","提示",JOptionPane.PLAIN_MESSAGE);
                    dispose();
                    new RankFrame(t_1.getText(),Chess.step);

             }else JOptionPane.showMessageDialog(null,"该昵称已被人使用","重新选名字噢！",JOptionPane.PLAIN_MESSAGE);
            }
        });
        b_2 = new JButton("狠心拒绝！");
        b_2.setFont(new Font("楷体",Font.BOLD,15));
        b_2.setBounds(150,170,120,30);
        add(b_2);
        b_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }
}
