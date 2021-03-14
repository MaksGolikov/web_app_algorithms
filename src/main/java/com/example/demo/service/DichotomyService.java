package com.example.demo.service;

import com.example.demo.data.DichotomyData;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DichotomyService {
    void calculationDichotomyMethod(DichotomyData data);

    String rootIntervalIsolation();

    String[] resultOfCalculation();
}
