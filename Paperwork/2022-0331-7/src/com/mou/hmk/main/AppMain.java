package com.mou.hmk.main;

import com.mou.hmk.ui.MainForm;

import javax.swing.*;


public class AppMain {
    public static JFrame frame = new JFrame("Demo");
    public static void main(String[] args) {

        frame.setContentPane(new MainForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
