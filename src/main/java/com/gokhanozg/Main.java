package com.gokhanozg;

import javax.swing.*;

/**
 * Created by Gokhan Ozgozen on 27-Sep-18.
 */
public class Main {

    public static void main(String[] args) {
//        double a1 = 18;
//        double a2 = 24;
//        double a3 = 36;
//        double a4 = 48;
        double a1 = 1.5d;
        double a2 = 1d;
//        double a3 = 2.5d;
//        double a4 = 1.74d;

        System.out.println(gcd(a1,a2));


    }

    public static double lcm(double... doubles) {
        double tmp = lcm(doubles[0], doubles[1]);
        for (int i = 2; i < doubles.length; i++) {
            tmp = lcm(tmp, doubles[i]);
        }
        return tmp;
    }

    public static double gcd(double a, double b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static double lcm(double a, double b) {
        return a * b / gcd(a, b);
    }
}
