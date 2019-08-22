package com.hania;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons {

    JFrame jframe;
    JLabel jLabel;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.start();
    }

    public void start(){
        jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Chanage label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change color");
        colorButton.addActionListener(new ColorListener());

        jLabel = new JLabel("This is label");
        MyImagePanel panel = new MyImagePanel();

        jframe.getContentPane().add(BorderLayout.SOUTH, colorButton);
        jframe.getContentPane().add(BorderLayout.CENTER, panel);
        jframe.getContentPane().add(BorderLayout.EAST, labelButton);
        jframe.getContentPane().add(BorderLayout.WEST, jLabel);

        jframe.setSize(400,300);
        jframe.setVisible(true);
    }


    class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            jLabel.setText("Label changed!");
        }
    }

    class ColorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            jframe.repaint();
        }
    }

}
