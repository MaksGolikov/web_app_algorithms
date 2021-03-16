package com.example.demo.service.impl;

import com.example.demo.data.DichotomyData;
import com.example.demo.service.DichotomyService;
import com.example.demo.util.DichotomyUtil;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class DichotomyServiceImpl implements DichotomyService {
    private Map<Double, Double> mapOfRootIsolationInterval;
    private String[] arrAnswer;


    @Override
    public void calculationDichotomyMethod(DichotomyData data) {


        double epsilon = 0.0001;
        double leftBorder = 0;
        double rightBorder = 0;
        double x = 0;
        double fA = 0;
        double fX = 0;
        double multipleFaFx = 0;


        mapOfRootIsolationInterval = new LinkedHashMap<>();
        List<Double> listOfFxOnEachIter = new ArrayList<>();
        int previous = 0;
        int now = 1;

        //check root isolation interval
        for (double i = data.getLeft(); i <= data.getRight(); i = i + 0.1) {
            listOfFxOnEachIter.add(DichotomyUtil.calcFuncFromParam(i));

            if (i > data.getLeft()) {
                if ((listOfFxOnEachIter.get(previous) < 0 && listOfFxOnEachIter.get(now) > 0) ||
                        (listOfFxOnEachIter.get(previous) > 0 && listOfFxOnEachIter.get(now) < 0)) {

                    System.out.println("["+(i-0.1) +" ; "+i+"]");
                    mapOfRootIsolationInterval.put(i - 0.1, i);
                }
                previous++;
                now++;
            }
        }

        arrAnswer = new String[mapOfRootIsolationInterval.size()];

        //print list
        for (int i = 0; i < listOfFxOnEachIter.size(); i++) {
            System.out.println(i + "  " + listOfFxOnEachIter.get(i));
        }

        //print map
        for (Map.Entry<Double, Double> map : mapOfRootIsolationInterval.entrySet()) {
            System.out.println("[" + map.getKey() + ";" + map.getValue() + "]");
        }

        int k = 1;
        for (Map.Entry<Double, Double> map : mapOfRootIsolationInterval.entrySet()) {

            leftBorder = map.getKey();
            rightBorder = map.getValue();

            x = (leftBorder + rightBorder) / 2;
            fA = DichotomyUtil.calcFuncFromParam(leftBorder);
            fX = DichotomyUtil.calcFuncFromParam(x);
            multipleFaFx = fA * fX;
            while (true) {
                if (multipleFaFx > 0) {
                    leftBorder = x;
                }
                if (multipleFaFx < 0) {
                    rightBorder = x;
                }
                x = (leftBorder + rightBorder) / 2;
                fA = DichotomyUtil.calcFuncFromParam(leftBorder);
                fX = DichotomyUtil.calcFuncFromParam(x);
                multipleFaFx = fA * fX;
                if (Math.abs(fX) < epsilon) {
                    arrAnswer[k - 1] = "For " + k + " interval #x# equals = " + x;
                    k++;
                    break;
                }
            }
        }

    }

    @Override
    public String rootIntervalIsolation() {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Double, Double> map : mapOfRootIsolationInterval.entrySet()) {
            str.append("---[ ").append(new DecimalFormat().format(map.getKey())).append(";").append(new DecimalFormat().format(map.getValue())).append(" ]---");
        }
        return str.toString();
    }

    @Override
    public String[] resultOfCalculation() {
        return arrAnswer;
    }
}
