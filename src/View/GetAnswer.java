package View;

import Chess.*;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;

public class GetAnswer extends JFrame  {
    public static void main(String[] args) {
        new GetAnswer();
    }
    private JPanel jp;
    private JTable t_step;
    private JButton b_dispose;
    public GetAnswer(){
        setUndecorated(true);
        setBounds(300, 70, 180,180);

        init();
        setVisible(true);

    }
    public void init(){

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

        Object[] title = {"","","","","","","",""};
        Object[][] chessBoardList = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoardList[i][j] = String.valueOf(ChessAlgorithm.chessboard[i][j]);
            }
        }
        t_step = new JTable(chessBoardList,title);
        JScrollPane pane = new JScrollPane();
        pane.setBounds(20, 20,140, 140);
        pane.getViewport().add(t_step);
        add(pane);
        t_step.setFont(new Font("楷体", Font.CENTER_BASELINE, 10));
        this.getContentPane().add(pane);

        ImageIcon imageIcon10 = new ImageIcon("src/Image/dispose.png");
        b_dispose = new JButton();
        b_dispose.setIcon(imageIcon10);
        b_dispose.setBounds(160,0,15,15);
        b_dispose.setBorderPainted(false);
        b_dispose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        add(b_dispose);
    }
}
