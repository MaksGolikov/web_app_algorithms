package com.example.demo.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IterationData {
    private double x00;
    private double x01;
    private double x02;
    private double x03;

    private double x10;
    private double x11;
    private double x12;
    private double x13;

    private double x20;
    private double x21;
    private double x22;
    private double x23;

    private double x30;
    private double x31;
    private double x32;
    private double x33;

    private double b0;
    private double b1;
    private double b2;
    private double b3;

    @Override
    public String toString() {
        return "IterationData{" +
                "x00=" + x00 +
                ", x01=" + x01 +
                ", x02=" + x02 +
                ", x03=" + x03 +
                ", x10=" + x10 +
                ", x11=" + x11 +
                ", x12=" + x12 +
                ", x13=" + x13 +
                ", x20=" + x20 +
                ", x21=" + x21 +
                ", x22=" + x22 +
                ", x23=" + x23 +
                ", x30=" + x30 +
                ", x31=" + x31 +
                ", x32=" + x32 +
                ", x33=" + x33 +
                ", b0=" + b0 +
                ", b1=" + b1 +
                ", b2=" + b2 +
                ", b3=" + b3 +
                '}';
    }
}
