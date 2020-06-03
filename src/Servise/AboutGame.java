package Servise;

import javax.swing.*;
import java.awt.*;

public class AboutGame extends JFrame {
    private JLabel l_1,l_2,l_3,l_4,l_5,l_6,l_7,l_8,l_9,l_10,l_11,l_12;
    public  AboutGame(){
        setBounds(500,250,530,530);
        setTitle("马踏棋盘规则");
        init();
        setVisible(true);
    }
    public void init(){
        setLayout(null);
        l_1 = new JLabel("    此游戏不同于别的国际象棋玩法，棋盘只出现了一个马棋，这个棋");
        l_1.setBounds(10,10,500,40);
        l_1.setFont(new Font("楷体",Font.BOLD,15));
        add(l_1);
        l_2 = new JLabel("子只能通过走日字的规则在棋盘中行走，每个被走过的方格将会被标记，");
        l_2.setBounds(10,40,500,40);
        l_2.setFont(new Font("楷体",Font.BOLD,15));
        add(l_2);
        l_3 = new JLabel("每个方格只能标记一次，通过您的鼠标点击行走马棋，直到棋盘中的所有");
        l_3.setBounds(10,70,500,40);
        l_3.setFont(new Font("楷体",Font.BOLD,15));
        add(l_3);
        l_4 = new JLabel("的方格都被标记，即为挑战成功。您可以先设置马的初始位置，若点击开");
        l_4.setBounds(10,100,500,40);
        l_4.setFont(new Font("楷体",Font.BOLD,15));
        add(l_4);
        l_5 = new JLabel("始游戏，棋盘上将会出现马棋，马的周围还会出现可走所有位置的提示，");
        l_5.setBounds(10,130,500,40);
        l_5.setFont(new Font("楷体",Font.BOLD,15));
        add(l_5);
        l_6 = new JLabel("点击任意一个提示位置后，马即可行走到点击处方格，并接着出现提示位");
        l_6.setBounds(10,160,500,40);
        l_6.setFont(new Font("楷体",Font.BOLD,15));
        add(l_6);
        l_7 = new JLabel("置，不出现提示位置时，即为挑战失败，会出现提示保存窗口，可以查看");
        l_7.setBounds(10,190,500,40);
        l_7.setFont(new Font("楷体",Font.BOLD,15));
        add(l_7);
        l_8 = new JLabel("排行榜，如果用户想挑战成功的话，您可点击查看路径，输入初始位置，");
        l_8.setBounds(10,220,500,40);
        l_8.setFont(new Font("楷体",Font.BOLD,15));
        add(l_8);
        l_9 = new JLabel("可出现迷你棋盘，每个方格中会写入正确的马的路径。可点击重新开始来");
        l_9.setBounds(10,250,500,40);
        l_9.setFont(new Font("楷体",Font.BOLD,15));
        add(l_9);
        l_10 = new JLabel("重新设置马的初始位置并且清空棋盘。");
        l_10.setBounds(10,280,500,40);
        l_10.setFont(new Font("楷体",Font.BOLD,15));
        add(l_10);
        l_11 = new JLabel("    大致功能就是这样啦，祝你游戏愉快哈哈哈！！！");
        l_11.setBounds(10,310,500,40);
        l_11.setFont(new Font("楷体",Font.BOLD,15));
        add(l_11);
        l_12 = new JLabel("本游戏由乔保杰大佬开发，若有问题请加qq：1270973227");
        l_12.setBounds(10,360,500,40);
        l_12.setFont(new Font("楷体",Font.BOLD,18));
        add(l_12);
    }
}
