package com.ma.raymond.vinance.utils;

public class MathUtil {
    public static double round(double value, int precision){
        double base=Math.pow(10,precision);
        return Math.round(value * base )/base;
    }
}
