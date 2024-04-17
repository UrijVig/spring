package com.example.HomeWork04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class RandomController {
    @GetMapping("/random")
    public String getRandomNumber(Model model){
        Random random = new Random();
        model.addAttribute("rnumber", random.nextInt(50));
        return "random-number";
    }
}
