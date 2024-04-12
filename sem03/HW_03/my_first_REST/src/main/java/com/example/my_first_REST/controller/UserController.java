package com.example.my_first_REST.controller;

import com.example.my_first_REST.domen.User;
import com.example.my_first_REST.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getAllData();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.processRegistration(user);
        return "User added from body!";
    }
    @PostMapping("/{name}/{age}/{email}")
    public String userAddFromBody(@PathVariable("name") String name,@PathVariable("age") int age,@PathVariable("email") String email )
    {
        service.processRegistration(new User(name, age, email));
        return "User added from body!";
    }
}
