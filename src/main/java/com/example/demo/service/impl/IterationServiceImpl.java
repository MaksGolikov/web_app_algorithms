package com.example.demo.service.impl;

import com.example.demo.data.IterationData;
import com.example.demo.service.IterationService;
import com.example.demo.util.CalculationUtil;
import com.example.demo.util.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class IterationServiceImpl implements IterationService {
    @Override
    public void calculation(IterationData iterationData) {
        double [] answerX = CalculationUtil.calc(iterationData);
    }

    @Override
    public String show() {
        return StringUtil.answer();
    }
}
