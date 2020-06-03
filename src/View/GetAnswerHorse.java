package View;

import Chess.ChessAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.zip.Inflater;

public class GetAnswerHorse extends JFrame {
    private JLabel l_row,l_column;
    private JTextField t_row,t_column;
    private JButton b_sure;

    public static void main(String[] args) {
        new GetAnswerHorse();
    }
    public  GetAnswerHorse(){
        setBounds(500,200,300,240);
        init();

        setVisible(true);
    }
    public void init(){
        setLayout(null);
        l_row = new JLabel("要展示答案的马的初始行");
        l_row.setBounds(20,20,200,40);
        l_row.setFont(new Font("楷体",Font.BOLD,15));
        add(l_row);
        l_column= new JLabel("要展示答案的马的初始列");
        l_column.setBounds(20,80,210,40);
        l_column.setFont(new Font("楷体",Font.BOLD,15));
        add(l_column);
        t_column = new JTextField();
        t_column.setBounds(210,20,40,40);
        add(t_column);
        t_row = new JTextField();
        t_row.setBounds(210,80,40,40);
        add(t_row);
        b_sure = new JButton("确定位置");
        b_sure.setBounds(90,150,100,30);
        b_sure.setFont(new Font("楷体",Font.BOLD,15));
        b_sure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(Integer.valueOf(t_row.getText())>0&&Integer.valueOf(t_row.getText())<9&&Integer.valueOf(t_column.getText())>0&&Integer.valueOf(t_column.getText())<9){
                    JOptionPane.showMessageDialog(null,"展示路径","答案",JOptionPane.PLAIN_MESSAGE);
                    ChessAlgorithm.getStep( Integer.valueOf(t_column.getText()),Integer.valueOf(t_row.getText()));
                    for (int[] rows : ChessAlgorithm.chessboard) {
                        for (int step : rows) {
                            System.out.print(step + "\t");
                        }
                        System.out.println();
                    }
                    dispose();
                    new GetAnswer();
                }else {
                    JOptionPane.showMessageDialog(null,"输入位置有误，请重新输入","答案",JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        add(b_sure);
    }
}
