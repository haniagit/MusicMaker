package com.hania;

import javax.swing.*;
import java.awt.*;

public class Animation {

    int x = 70;
    int y = 70;

    public static void main(String[] args) {
        Animation gui = new Animation();
        gui.start();
    }

    public void start(){
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyImagePanel panel = new MyImagePanel();

        jFrame.getContentPane().add(panel);
        jFrame.setSize(300,300);
        jFrame.setVisible(true);

        for(int i=0; i < 130; i++){
            x++;
            y++;
            panel.repaint();

            try{
                Thread.sleep(50);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    class MyImagePanel extends JPanel {
        public void paintComponent(Graphics g){
            g.setColor(Color.green);
            g.fillOval(x,y,40,40);
        }
    }
}
