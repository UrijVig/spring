package com.example.my_first_grud.service;

import com.example.my_first_grud.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface iService {
    List<User> findAll();

    User saveUser(User user);

    void deleteById(int id);

    User getUserById(int id);

    void updateUserById(User user);
}
