package com.example.demo.service.impl;

import com.example.demo.data.IterationData;
import com.example.demo.service.IterationService;
import com.example.demo.util.CalculationUtil;
import org.springframework.stereotype.Service;

@Service
public class IterationServiceImpl implements IterationService {
    private String str;
    @Override
    public void calculation(IterationData iterationData) {
        double [] answerX = CalculationUtil.calc(iterationData);
        String result1 = String.format("%.3f", answerX[0]);
        String result2 = String.format("%.3f", answerX[1]);
        String result3 = String.format("%.3f", answerX[2]);
        String result4 = String.format("%.3f", answerX[3]);
        str = "x1 = "+result1+"\n        x2 = "+result2+"\n        x3 = "+result3+"\n        x4 = "+result4+" ";
    }

    @Override
    public String show() {
        //return StringUtil.answer();
        return str;
    }
}
