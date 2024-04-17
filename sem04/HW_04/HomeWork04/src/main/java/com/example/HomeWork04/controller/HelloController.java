package com.example.HomeWork04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    @RequestMapping("/hello")
//    public String helloWorld(){
//        return "hello.html";
//    }
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }
}
