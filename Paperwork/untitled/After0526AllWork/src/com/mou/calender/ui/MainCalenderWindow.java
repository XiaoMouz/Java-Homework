package com.mou.calender.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainCalenderWindow extends JFrame {
    DefaultTableModel model;
    Calendar cal = new GregorianCalendar();
    JLabel label;

    MainCalenderWindow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("日历");
        this.setSize(300,200);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton b1 = new JButton("<-");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                cal.add(Calendar.MONTH, -1);
                updateMonth();
            }
        });

        JButton b2 = new JButton("->");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                cal.add(Calendar.MONTH, +1);
                updateMonth();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(b1,BorderLayout.WEST);
        panel.add(label,BorderLayout.CENTER);
        panel.add(b2,BorderLayout.EAST);


        String [] columns = {"日","一","二","三","四","五","牛"};
        model = new DefaultTableModel(null,columns);
        JTable table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);

        this.add(panel,BorderLayout.NORTH);
        this.add(pane,BorderLayout.CENTER);

        this.updateMonth();

    }

    void updateMonth() {
        cal.set(Calendar.DAY_OF_MONTH, 1);

        String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
        int year = cal.get(Calendar.YEAR);
        label.setText(month + " " + year);

        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

        model.setRowCount(0);
        model.setRowCount(weeks);

        int i = startDay - 1;
        for (int day = 1; day <= numberOfDays; day++) {
            model.setValueAt(day, i / 7, i % 7);
            i = i + 1;
        }

        //填充上一月日期
        cal.add(Calendar.DAY_OF_MONTH, -1);
        int maxDaysOfLastMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int maxWeekOfLastMonth = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        int j = 0;
        for (int day = maxDaysOfLastMonth - (maxWeekOfLastMonth * 7 - maxDaysOfLastMonth); day <= maxDaysOfLastMonth; day++) {

            if (model.getValueAt(0, j) == null || model.getValueAt(0, j).equals(0) || model.getValueAt(0, j).equals(0)) {
                model.setValueAt(day, 0, j++);
            }
        }
        cal.add(Calendar.DAY_OF_MONTH, +1);

        //填充下一月日期
        cal.add(Calendar.DAY_OF_MONTH, +1);
        int maxDaysOfNextMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int maxWeekOfNextMonth = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        int k = 0;
        for (int day = 1; day <= maxDaysOfLastMonth; day++) {

            if (model.getValueAt(0, k) == null || model.getValueAt(0, k).equals(0) || model.getValueAt(0, k).equals(0)) {
                model.setValueAt(day, 0, k++);
            }
        }
        cal.add(Calendar.DAY_OF_MONTH, -1);
    }

    public static void main(String[] arguments) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        MainCalenderWindow sc = new MainCalenderWindow();
    }
}
