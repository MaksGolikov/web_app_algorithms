package com.example.demo.service.impl;

import com.example.demo.data.IterationData;
import com.example.demo.service.IterationService;
import com.example.demo.util.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class IterationServiceImpl implements IterationService {
    IterationData iterationData1 = new IterationData();
    @Override
    public void calculation(IterationData iterationData) {
        System.out.println(iterationData.getX00());
        System.out.println(iterationData.getX01());
        iterationData1 = iterationData;
    }

    @Override
    public String show() {
        //return StringUtil.answer();
        return iterationData1.toString();
    }
}
