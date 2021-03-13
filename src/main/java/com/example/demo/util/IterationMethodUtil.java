package com.example.demo.util;

import com.example.demo.data.IterationData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IterationMethodUtil {
    private static final int sizeOfMatrix = 4;
    private static final double[] tempArrOfAnswer = new double[sizeOfMatrix];

    public static double[] calc(IterationData iterationData) {

        //create arr of coefficient
        double[][] arrOfCoefficient = {
                {iterationData.getX00(), iterationData.getX01(), iterationData.getX02(), iterationData.getX03()},
                {iterationData.getX10(), iterationData.getX11(), iterationData.getX12(), iterationData.getX13()},
                {iterationData.getX20(), iterationData.getX21(), iterationData.getX22(), iterationData.getX23()},
                {iterationData.getX30(), iterationData.getX31(), iterationData.getX32(), iterationData.getX33()}
        };

        //make copy of arr
        double[][] copyArrOfCoefficient = new double[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                copyArrOfCoefficient[i][j] = arrOfCoefficient[i][j];
            }
        }

        //create arr of answer
        double[] arrOfAnswer = {
                3 * iterationData.getB0(), iterationData.getB0() - 6, 15 - iterationData.getB0(), iterationData.getB0() + 2
        };

        //check determinant
        double determinant = DeterminantUtil.determinant(sizeOfMatrix, arrOfCoefficient);
        if (determinant == 0) {
            System.exit(1);
        }

        //check условние преобладания
        double sum = 0;
        for (int i = 0; i < sizeOfMatrix; i++) {
            sum = 0;
            for (int j = 0; j < sizeOfMatrix; j++) {
                sum += Math.abs(arrOfCoefficient[i][j]);
            }
            sum = sum - Math.abs(arrOfCoefficient[i][i]);
            if (sum > Math.abs(arrOfCoefficient[i][i])) {
                System.exit(1);
            }
        }

        List<Double> listOfInitialApproximation = new ArrayList<>(4);
        listOfInitialApproximation.add(0.7 * iterationData.getB0());
        listOfInitialApproximation.add(1.0);
        listOfInitialApproximation.add(2.0);
        listOfInitialApproximation.add(0.5);

        double[] answerX = new double[sizeOfMatrix];
        double[] moduleOfSubtraction = new double[sizeOfMatrix];
        List<Double> temp = new ArrayList<>(4);
        temp.add(0.0);
        temp.add(0.0);
        temp.add(0.0);
        temp.add(0.0);


        int k = 0;
        while (true) {
            answerX = iterations(iterationData, listOfInitialApproximation, arrOfAnswer);
            moduleOfSubtraction = moduleOfSubtraction(listOfInitialApproximation, answerX);

            for (int i = 0; i < 4; i++) {
                System.out.println("x" + i + " = " + answerX[i]);
            }
            System.out.println();

            for (int i = 0; i < sizeOfMatrix; i++) {
                temp.set(i, moduleOfSubtraction[i]);
            }
            double maxValue = Collections.max(temp);
            if (maxValue <= 0.005) {
                System.out.println("number of iter = " + k);
                break;
            }
            k++;
        }

        //check result
        double[] checkSum = new double[sizeOfMatrix];
        checkSum[0] = iterationData.getX00() * answerX[0] +
                iterationData.getX01() * answerX[1] +
                iterationData.getX02() * answerX[2] +
                iterationData.getX03() * answerX[3];
        checkSum[1] = iterationData.getX10() * answerX[0] +
                iterationData.getX11() * answerX[1] +
                iterationData.getX12() * answerX[2] +
                iterationData.getX13() * answerX[3];
        checkSum[2] = iterationData.getX20() * answerX[0] +
                iterationData.getX21() * answerX[1] +
                iterationData.getX22() * answerX[2] +
                iterationData.getX23() * answerX[3];
        checkSum[3] = iterationData.getX30() * answerX[0] +
                iterationData.getX31() * answerX[1] +
                iterationData.getX32() * answerX[2] +
                iterationData.getX33() * answerX[3];

        for (int i = 0; i < sizeOfMatrix; i++) {
            System.out.println(i +" line equals = "+checkSum[i]);
        }



        return answerX;
    }

    private static double[] moduleOfSubtraction(List<Double> listOfInitialApproximation, double[] answerX) {
        double d1 = Math.abs(listOfInitialApproximation.get(0) - answerX[0]);
        listOfInitialApproximation.set(0, tempArrOfAnswer[0]);
        double d2 = Math.abs(listOfInitialApproximation.get(1) - answerX[1]);
        listOfInitialApproximation.set(1, tempArrOfAnswer[1]);
        double d3 = Math.abs(listOfInitialApproximation.get(2) - answerX[2]);
        listOfInitialApproximation.set(2, tempArrOfAnswer[2]);
        double d4 = Math.abs(listOfInitialApproximation.get(3) - answerX[3]);
        listOfInitialApproximation.set(3, tempArrOfAnswer[3]);
        return new double[]{d1, d2, d3, d4};
    }

    private static double[] iterations(IterationData iterationData, List<Double> listOfInitialApproximation, double[] arrOfAnswer) {
        tempArrOfAnswer[0] = (arrOfAnswer[0] + (-1) *
                (iterationData.getX01() * listOfInitialApproximation.get(1) +
                        iterationData.getX02() * listOfInitialApproximation.get(2) +
                        iterationData.getX03() * listOfInitialApproximation.get(3))) /
                iterationData.getX00();

        double a = iterationData.getX10() * listOfInitialApproximation.get(0);
        double b = iterationData.getX12() * listOfInitialApproximation.get(2);
        double c = iterationData.getX13() * listOfInitialApproximation.get(3);

        tempArrOfAnswer[1] = (arrOfAnswer[1] + (-1) *
                (a+b+c)) /
                iterationData.getX11();


        tempArrOfAnswer[2] = (arrOfAnswer[2] + (-1) *
                (iterationData.getX20() * listOfInitialApproximation.get(0) +
                        iterationData.getX21() * listOfInitialApproximation.get(1) +
                        iterationData.getX23() * listOfInitialApproximation.get(3))) /
                iterationData.getX22();
        tempArrOfAnswer[3] = (arrOfAnswer[3] + (-1) *
                (iterationData.getX30() * listOfInitialApproximation.get(0) +
                        iterationData.getX31() * listOfInitialApproximation.get(1) +
                        iterationData.getX32() * listOfInitialApproximation.get(2))) /
                iterationData.getX33();
        return tempArrOfAnswer;
    }
}
