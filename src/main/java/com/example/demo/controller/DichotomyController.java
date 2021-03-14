package com.example.demo.controller;

import com.example.demo.data.DichotomyData;
import com.example.demo.service.DichotomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DichotomyController {

    private final DichotomyService dichotomyService;

    public DichotomyController(DichotomyService dichotomyService) {
        this.dichotomyService = dichotomyService;
    }

    @GetMapping("/dichotomy_result")
    public String dichotomyResult (Model model){
        model.addAttribute("rootIntervalIsolation", dichotomyService.rootIntervalIsolation());
        model.addAttribute("result", dichotomyService.resultOfCalculation());
        return "dichotomy_result";
    }

    @GetMapping("/home_dichotomy")
    public String homeDichotomy(){
        return "home_dichotomy";
    }

    @PostMapping("/home_dichotomy")
    public String dichotomyMethod(DichotomyData data){
        dichotomyService.calculationDichotomyMethod(data);
        return "redirect:/dichotomy_result";
    }
}
