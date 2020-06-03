package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayFrame extends JFrame {
    private JButton b_play;
    public PlayFrame(){
        setLayout(null);
        setUndecorated(true);
        setBounds(550,250,400,350);
        init();
        setVisible(true);
    }
    public void init(){
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
        b_play = new JButton();
     b_play.setBounds(105,250,200,60);
     ImageIcon imageIcon = new ImageIcon("src/Image/start.png");
     b_play.setIcon(imageIcon);
     //B_play.setBorderPainted(false);
     //B_play.setContentAreaFilled(false);
     b_play.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
             new StatementFrame();
             dispose();
         }
     });
    add(b_play);
    }
    public void paint(Graphics g){
        super.paint(g);
        ImageIcon imageIcon = new ImageIcon("src/Image/Play.png");
        g.drawImage(imageIcon.getImage(),0,0,400,350,null);
    }
}
