package View;

import Chess.Chess;
import Chess.ChessAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SureFrame extends JFrame {
    public static void main(String[] args) {
        new SureFrame();
    }
    private JButton b_yes,b_no;
    private JLabel l_sure;
    public SureFrame(){
        setTitle("你确定吗？？？");
        setBounds(400,300,750,160);
        init();
        setVisible(true);
    }
    public void init(){
        setLayout(null);
        l_sure = new JLabel("是不是觉得自己笨不可能完成这个游戏？");
        l_sure.setFont(new Font("楷体",Font.BOLD,18));
        l_sure.setBounds(50,20,630,40);
        add(l_sure);
        b_yes = new JButton("我承认我笨，过不了这个游戏！");
        b_yes.setFont(new Font("楷体",Font.BOLD,15));
        b_yes.setBounds(50,70,250,23);
        b_yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JOptionPane.showMessageDialog(null,"给你答案","提示",JOptionPane.PLAIN_MESSAGE);
                dispose();
                for(int i = 0;i<8;i++)
                {
                    for(int j = 0;j<8;j++){
                        ChessAlgorithm.chessboard[i][j] = 0;
                    }
                }
                for(int n = 0;n<Chess.visited.length;n++){
                    Chess.visited[n] = false;
                }

                new GetAnswerHorse();
            }
        });
        add(b_yes);
        b_no = new JButton("这游戏太简单了，我只是不小心点错了！");
        b_no.setFont(new Font("楷体",Font.BOLD,15));
        b_no.setBounds(350,70,310,23);
        b_no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               JOptionPane.showMessageDialog(null,"我信了，祝你成功！","提示",JOptionPane.PLAIN_MESSAGE);
               dispose();
            }
        });
        add(b_no);
    }
}
