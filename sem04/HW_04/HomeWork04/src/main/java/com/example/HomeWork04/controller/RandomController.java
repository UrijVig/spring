package com.example.HomeWork04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class RandomController {
    /**
     * Метод для генерации случайного числа на странице
     *
     * @param model модель представления Spring MVC
     * @return шаблон отображаемой страницы
     */
    @GetMapping("/random")
    public String getRandomNumber(Model model){
        Random random = new Random();
        model.addAttribute("rnumber", random.nextInt(50));
        return "random-number";
    }
}
