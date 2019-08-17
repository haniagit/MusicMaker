package com.hania;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIv1 implements ActionListener {
    private JButton button;

    public static void main(String[] args) {
        GUIv1 guIv1 = new GUIv1();
        guIv1.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("Click me");



        button.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     button.setText("Clicked!");
    }

}
