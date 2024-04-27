package com.example.my_first_grud.repository;

import com.example.my_first_grud.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iRepository {
    List<User> findAll();
    User save(User user);
    void deleteById(int id);

    User getUserById(int id);

    User updateUserById(User user);
}
