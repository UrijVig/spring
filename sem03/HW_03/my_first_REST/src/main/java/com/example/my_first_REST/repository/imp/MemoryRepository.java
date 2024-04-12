package com.example.my_first_REST.repository.imp;

import com.example.my_first_REST.domen.User;
import com.example.my_first_REST.repository.iRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@Primary
@Profile("task1")
public class MemoryRepository implements iRepository<User> {
    private final List<User> users = new ArrayList<>();
    public List<User> getAll() {
        return users;
    }

    public User save(User user) {
        users.add(user);
        return user;
    }

    public User deleteById(int id) {
        return users.remove(id);
    }

    public User getById(int id) {
        return users.get(id);
    }

    public User updateById(User user) {
        User find = users.get(user.getId());
        find.setName(user.getName());
        find.setAge(user.getAge());
        find.setEmail(user.getEmail());
        return user;
    }
}
