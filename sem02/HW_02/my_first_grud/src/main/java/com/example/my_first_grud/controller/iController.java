package com.example.my_first_grud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.my_first_grud.model.User;

@Controller
public interface iController {
    String findAll(Model model);

    String createUserForm(User user);

    String createUser(User user);

    String deleteUserById(int id);
}
