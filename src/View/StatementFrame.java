package View;

import javax.swing.*;
import java.awt.*;

/*
* 过度界面
* */
public class StatementFrame extends JFrame implements Runnable{
    ImageIcon house = new ImageIcon("src/Image/horse3.png");
    ImageIcon bg = new ImageIcon("src/Image/bgS.jpg");
    private int lx = 500,ly = 170,vx =16 , vy =5;
    public StatementFrame() {
        Thread newT = new Thread(this);
        newT.start();
        setSize(600,400);
        this.setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bg.getImage(),0,0,600,400,null);
        g.drawImage(house.getImage(),lx,ly,100,80,null);
    }

    public static void main(String[] args) {
        new StatementFrame();
    }
    @Override
    public void run() {
        int i = 0;
        int record = 0;
        boolean decide = true;
        while (decide){
            try {
                if (i == 10){
                    vy =-vy;
                    i=0;
                }
                Thread.sleep(100);
                lx -= vx;
                ly +=vy;
                repaint();
                i++;
                record++;
            }catch (Exception e){
                e.printStackTrace();
            }
            if (record ==33){
                decide = false;
                Frame[] jf =  this.getFrames();
                for(Frame the:jf){
                    the.setVisible(false);
                }
                new MainFrame();
            }
        }
    }
}
