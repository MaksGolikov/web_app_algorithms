package com.example.demo.util;

import java.math.BigDecimal;

public class DichotomyUtil {
    public static double calcFuncFromParam(double i) {
        //return Math.pow(i, 3)-2.8*Math.pow(i,2) - 6.2 * i+3.7;
        return 0.2 * Math.pow(i, 3) + 0.7 * Math.pow(i, 2) - 3.7 * i + 2.3;
    }
}
