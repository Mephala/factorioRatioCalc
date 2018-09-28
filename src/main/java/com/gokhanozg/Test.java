package com.gokhanozg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Gokhan Ozgozen on 27-Sep-18.
 */
public class Test {
    private JTextField in1t;
    private JTextField in2t;
    private JTextField in3t;
    private JTextField in4t;
    private JTextField in1q;
    private JTextField in2q;
    private JTextField in3q;
    private JTextField in4q;
    private JPanel testPanel;
    private JButton calculate;
    private JLabel results;
    private JTextField q1;
    private JTextField q2;
    private JTextField q3;
    private JTextField q4;
    private JTextField t;
    private JButton resetButton;
    private static final int MAX_FACTORY = 1000;

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("Test");
        frame.setContentPane(new Test().testPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Test() {
        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double in1c = !isEmpty(in1t.getText()) ? Double.parseDouble(in1q.getText()) / Double.parseDouble(in1t.getText()) : 0d;
                double in2c = !isEmpty(in2t.getText()) ? Double.parseDouble(in2q.getText()) / Double.parseDouble(in2t.getText()) : 0d;
                double in3c = !isEmpty(in3t.getText()) ? Double.parseDouble(in3q.getText()) / Double.parseDouble(in3t.getText()) : 0d;
                double in4c = !isEmpty(in4t.getText()) ? Double.parseDouble(in4q.getText()) / Double.parseDouble(in4t.getText()) : 0d;
                if (in1c != 0d && in2c != 0d && in3c != 0d && in4c != 0d) {
                    results.setText(calculate4way(in1c, in2c, in3c, in4c));
                } else if (in1c != 0d && in2c != 0d && in3c != 0d) {
                    results.setText(calculate3Way(in1c, in2c, in3c));
                } else if (in1c != 0d && in2c != 0d) {
                    results.setText(calculate2Way(in1c, in2c));
                } else {
                    results.setText(calculate1Way(in1c));
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                in1t.setText(null);
                in2t.setText(null);
                in3t.setText(null);
                in4t.setText(null);
                in1q.setText(null);
                in2q.setText(null);
                in3q.setText(null);
                in4q.setText(null);
                q1.setText(null);
                q2.setText(null);
                q3.setText(null);
                q4.setText(null);
                t.setText(null);
            }
        });

    }

    private String calculate2Way(double in1c, double in2c) {
        double time = Double.parseDouble(t.getText());
        double req1 = Double.parseDouble(q1.getText()) / time / in1c;
        double req2 = Double.parseDouble(q2.getText()) / time / in2c;
        int whole = 1;
        for (; whole < MAX_FACTORY; whole++) {
            double tmp1 = req1 * whole;
            double tmp2 = req2 * whole;
            if (Util.areWhole(tmp1, tmp2)) {
                break;
            }
        }
        if(whole == MAX_FACTORY){
            whole = 1;
            req1 = Util.normalizeDouble(req1);
            req2 = Util.normalizeDouble(req2);
            for (; whole < MAX_FACTORY; whole++) {
                double tmp1 = req1 * whole;
                double tmp2 = req2 * whole;
                if (Util.areWhole(tmp1, tmp2)) {
                    break;
                }
            }
        }
        return req1 * whole + " - " + req2 * whole + " - " + whole;
    }

    private String calculate3Way(double in1c, double in2c, double in3c) {
        double time = Double.parseDouble(t.getText());
        double req1 = Double.parseDouble(q1.getText()) / time / in1c;
        double req2 = Double.parseDouble(q2.getText()) / time / in2c;
        double req3 = Double.parseDouble(q3.getText()) / time / in3c;
        int whole = 1;
        for (; whole < MAX_FACTORY; whole++) {
            double tmp1 = req1 * whole;
            double tmp2 = req2 * whole;
            double tmp3 = req3 * whole;
            if (Util.areWhole(tmp1, tmp2, tmp3)) {
                break;
            }
        }
        if(whole == MAX_FACTORY){
            whole = 1;
            req1 = Util.normalizeDouble(req1);
            req2 = Util.normalizeDouble(req2);
            req3 = Util.normalizeDouble(req3);
            for (; whole < MAX_FACTORY; whole++) {
                double tmp1 = req1 * whole;
                double tmp2 = req2 * whole;
                double tmp3 = req3 * whole;
                if (Util.areWhole(tmp1, tmp2, tmp3)) {
                    break;
                }
            }
        }
        return req1 * whole + " - " + req2 * whole + " - " + req3 * whole + " - " + whole;
    }


    private String calculate1Way(double in1c) {
        double time = Double.parseDouble(t.getText());
        double req1 = Double.parseDouble(q1.getText()) / time / in1c;
        int whole = 1;
        for (; whole < MAX_FACTORY; whole++) {
            double tmp1 = req1 * whole;
            if (Util.areWhole(tmp1)) {
                break;
            }
        }
        if(whole == MAX_FACTORY){
            whole = 1;
            req1 = Util.normalizeDouble(req1);
            for (; whole < MAX_FACTORY; whole++) {
                double tmp1 = req1 * whole;
                if (Util.areWhole(tmp1)) {
                    break;
                }
            }
        }
        return req1 * whole + " - " + whole;
    }

    private String calculate4way(double in1c, double in2c, double in3c, double in4c) {
        double time = Double.parseDouble(t.getText());
        double req1 = Double.parseDouble(q1.getText()) / time / in1c;
        double req2 = Double.parseDouble(q2.getText()) / time / in2c;
        double req3 = Double.parseDouble(q3.getText()) / time / in3c;
        double req4 = Double.parseDouble(q4.getText()) / time / in4c;
        int whole = 1;
        for (; whole < MAX_FACTORY; whole++) {
            double tmp1 = req1 * whole;
            double tmp2 = req2 * whole;
            double tmp3 = req3 * whole;
            double tmp4 = req4 * whole;
            if (Util.areWhole(tmp1, tmp2, tmp3, tmp4)) {
                break;
            }
        }
        return req1 * whole + " - " + req2 * whole + " - " + req3 * whole + " - " + req4 * whole + " - " + whole;
    }

    public boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }


}
