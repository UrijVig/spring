package com.example.my_first_grud.controller.imp;

import com.example.my_first_grud.controller.iController;
import com.example.my_first_grud.model.User;
import com.example.my_first_grud.service.iService;
import com.example.my_first_grud.service.imp.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Component
@Log
public class UserController implements iController{
    @Autowired
    private iService service;

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = service.findAll();
        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        service.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUserById(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("user-update/{id}")
    public String updateUserForm(@PathVariable int id, Model model) {
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }
    @PostMapping("/user-update")
    public String updateUserById(User user) {
        service.updateUserById(user);
        return "redirect:/users";
    }



}
