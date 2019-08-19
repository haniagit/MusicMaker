package com.hania;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIv1 implements ActionListener {
    private JFrame jFrame;

    public static void main(String[] args) {
        GUIv1 guIv1 = new GUIv1();
        guIv1.go();
    }

    public void go() {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jButton = new JButton("Change color");
        jButton.addActionListener(this);

        MyImagePanel panel = new MyImagePanel();

        jFrame.getContentPane().add(BorderLayout.SOUTH, jButton);
        jFrame.getContentPane().add(BorderLayout.CENTER, panel);
        jFrame.setSize(300, 300);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.repaint();
    }

}
