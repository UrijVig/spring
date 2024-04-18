package com.example.HomeWork04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
//    /**
//     * Данный метод возвращает страницу hello.html, однако он не работает при подключённом Thymeleaf потому что файл находится в папке static
//     * @return
//     */
//    @RequestMapping("/hello")
//    public String helloWorld(){
//        return "hello.html";
//    }

    /**
     * Метод выводит приветствие на странице
     * @return сообщение для вывода на странице
     */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }
}
