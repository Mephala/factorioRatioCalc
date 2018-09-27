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
                } else if (in1c != 0d) {
                    results.setText(calculate1Way(in1c));
                }
            }
        });
    }

    private String calculate1Way(double in1c) {
        double time = Double.parseDouble(t.getText());
        double req1 = Double.parseDouble(q1.getText()) / time / in1c;
        double gcd = Util.gcd(req1, 1d);
        double val1 = req1 / gcd;
        double val2 = 1d / gcd;
        return val1 + " - " + val2;
    }

    private String calculate4way(double in1c, double in2c, double in3c, double in4c) {
        double time = Double.parseDouble(t.getText());
        double req1 = Double.parseDouble(q1.getText()) / time / in1c;
        double req2 = Double.parseDouble(q2.getText()) / time / in2c;
        double req3 = Double.parseDouble(q3.getText()) / time / in3c;
        double req4 = Double.parseDouble(q4.getText()) / time / in4c;
        double gcd = Util.gcd(req1, req2, req3, req4, 1d);
        double val1 = req1 / gcd;
        double val2 = req1 / gcd;
        double val3 = req1 / gcd;
        double val4 = req1 / gcd;
        double val5 = 1d / gcd;
        return val1 + " - " + val2 + " - " + val3 + " - " + val4 + " - " + val5;
    }

    public boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }


}
