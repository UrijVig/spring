package com.example.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    /**
     * общедоступный ресурс
     * @return шаблон
     */
    @GetMapping("/api/public")
    public String getPublicData() {
        return "public";
    }

    /**
     * ресурс доступный только пользователям с ролью ADMIN
     * @return шаблон
     */
    @GetMapping("/api/private")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getPrivateData() {
        return "private";
    }
    /**
     * меню ресурсов
     * @return шаблон
     */
    @GetMapping("/api")
    public String getMenu() {
        return "menu";
    }

    /**
     * перенаправление на кастомную страницу аутентификации
     * @return шаблон
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}