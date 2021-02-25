package com.example.demo.util;

import com.example.demo.data.IterationData;

public class CalculationUtil {
    public static double[] calc(IterationData iterationData){
        double arr [][]  =  {
                {iterationData.getX00(), iterationData.getX01(),iterationData.getX02(),iterationData.getX03()},
                {iterationData.getX10(), iterationData.getX11(),iterationData.getX12(),iterationData.getX13()},
                {iterationData.getX20(), iterationData.getX21(),iterationData.getX22(),iterationData.getX23()},
                {iterationData.getX30(), iterationData.getX31(),iterationData.getX32(),iterationData.getX33()}
        };  //new double[3][3];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


        return new double[] {};
    }
}
