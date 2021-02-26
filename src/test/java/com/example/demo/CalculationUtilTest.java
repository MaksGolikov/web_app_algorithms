package com.example.demo;

import com.example.demo.util.DeterminantUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculationUtilTest {
    private static final int numberInList = 30;
    private static final int sizeOfMatrix = 4;

    @Test
    public void test() {

        double[][] arrOfCoefficient = {
                {5, 1, -1, 1},
                {1, -4, 1, -1},
                {-1, 1, 4, 1},
                {1, 2, 1, -5}
        };

        double[][] copyArrOfCoefficient = new double[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                copyArrOfCoefficient[i][j] = arrOfCoefficient[i][j];
            }
        }

        double[] arrOfAnswer = {
                3 * numberInList, numberInList - 6, 15 - numberInList, numberInList + 2
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arrOfCoefficient[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < sizeOfMatrix; i++) {
            System.out.println(arrOfAnswer[i]);
        }

        DeterminantUtil.determinant(4, arrOfCoefficient);

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

        List<Double> list0fXOnMainDiagonal = new ArrayList<>(4);
        list0fXOnMainDiagonal.add(0.0);
        list0fXOnMainDiagonal.add(0.0);
        list0fXOnMainDiagonal.add(0.0);
        list0fXOnMainDiagonal.add(0.0);

        List<Double> temp = new ArrayList<>(4);
        temp.add(0.0);
        temp.add(0.0);
        temp.add(0.0);
        temp.add(0.0);

        List<Double> listOfInitialApproximation = new ArrayList<>(4);
        listOfInitialApproximation.add(0.7 * 30);
        listOfInitialApproximation.add(1.0);
        listOfInitialApproximation.add(2.0);
        listOfInitialApproximation.add(0.5);

        double [] answerX = new double[sizeOfMatrix];

        int k = 0;
        M : while (true) {

            arrOfCoefficient[0][0] = (arrOfAnswer[0] - listOfInitialApproximation.get(1) - listOfInitialApproximation.get(2) -
                    listOfInitialApproximation.get(3)) / copyArrOfCoefficient[0][0];
            arrOfCoefficient[0][1] = listOfInitialApproximation.get(1);
            arrOfCoefficient[0][2] = listOfInitialApproximation.get(2);
            arrOfCoefficient[0][3] = listOfInitialApproximation.get(3);

            list0fXOnMainDiagonal.set(0, arrOfCoefficient[0][0]);

            arrOfCoefficient[1][0] = listOfInitialApproximation.get(0);
            arrOfCoefficient[1][1] = (arrOfAnswer[1] - listOfInitialApproximation.get(0) - listOfInitialApproximation.get(2) -
                    listOfInitialApproximation.get(3)) / copyArrOfCoefficient[1][1];
            arrOfCoefficient[1][2] = listOfInitialApproximation.get(2);
            arrOfCoefficient[1][3] = listOfInitialApproximation.get(3);

            list0fXOnMainDiagonal.set(1, arrOfCoefficient[1][1]);

            arrOfCoefficient[2][0] = listOfInitialApproximation.get(0);
            arrOfCoefficient[2][1] = listOfInitialApproximation.get(1);
            arrOfCoefficient[2][2] = (arrOfAnswer[2] - listOfInitialApproximation.get(0) - listOfInitialApproximation.get(1) -
                    listOfInitialApproximation.get(3)) / copyArrOfCoefficient[2][2];
            arrOfCoefficient[2][3] = listOfInitialApproximation.get(3);

            list0fXOnMainDiagonal.set(2, arrOfCoefficient[2][2]);

            arrOfCoefficient[3][0] = listOfInitialApproximation.get(0);
            arrOfCoefficient[3][1] = listOfInitialApproximation.get(1);
            arrOfCoefficient[3][2] = listOfInitialApproximation.get(2);
            arrOfCoefficient[3][3] = (arrOfAnswer[3] - listOfInitialApproximation.get(0) - listOfInitialApproximation.get(1) -
                    listOfInitialApproximation.get(2)) / copyArrOfCoefficient[3][3];

            list0fXOnMainDiagonal.set(3, arrOfCoefficient[3][3]);


            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.printf("%.3f ",  arrOfCoefficient[i][j]);
                }
                System.out.println();
            }

            System.out.println( );

            if(k>=1){
                for (int i = 0; i < 4; i++) {
                    double a = Math.abs(list0fXOnMainDiagonal.get(i))-Math.abs(listOfInitialApproximation.get(i));
                    temp.set(i, a);
                }
                double maxValue = Collections.max(temp);
                if(maxValue<=0.005){
                    break M;
                }

            }

            for (int i = 0; i < sizeOfMatrix; i++) {
                listOfInitialApproximation.set(i, list0fXOnMainDiagonal.get(i));
            }

            k++;
        }

        answerX[0]=list0fXOnMainDiagonal.get(0);
        answerX[1]=list0fXOnMainDiagonal.get(1);
        answerX[2]=list0fXOnMainDiagonal.get(2);
        answerX[3]=list0fXOnMainDiagonal.get(3);

        System.out.printf("x1 = %.3f%n",answerX[0]);
        System.out.printf("x2 = %.3f%n",answerX[1]);
        System.out.printf("x3 = %.3f%n",answerX[2]);
        System.out.printf("x4 = %.3f%n",answerX[3]);
    }
}
