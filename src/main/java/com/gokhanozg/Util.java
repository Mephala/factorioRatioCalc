package com.gokhanozg;

/**
 * Created by Gokhan Ozgozen on 27-Sep-18.
 */
public class Util {

    public static double gcd(double... doubles) {
        double tmp = gcd(doubles[0], doubles[1]);
        for (int i = 2; i < doubles.length; i++) {
            tmp = gcd(tmp, doubles[i]);
        }
        return tmp;
    }


    private static double gcd(double a, double b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
