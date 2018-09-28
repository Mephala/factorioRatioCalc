package com.gokhanozg;

import java.math.BigDecimal;

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

    public static boolean areWhole(double... doubles) {
        boolean retval = true;
        for (double aDouble : doubles) {
            retval = retval && aDouble % 1 == 0;
        }
        return retval;
    }

    public static double normalizeDouble(double d) {
        return BigDecimal.valueOf(d).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
