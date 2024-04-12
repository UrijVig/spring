package com.example.my_first_REST.service;

import com.example.my_first_REST.domen.User;
import com.example.my_first_REST.repository.iRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DataProcessingService {

    private final iRepository<User> repository;

    public DataProcessingService(iRepository<User> repository) {
        this.repository = repository;
    }

    public List<User> getAllData() {
        return repository.getAll();
    }

    public void  addUser(User user)
    {
        repository.save(user);
    }

    public List<User> sortUsersByAge() {
        return repository.getAll().stream()
                .sorted(Comparator.comparing(User::getAge)).toList();
    }

    public List<User> filterUsersByAge(int age) {
        return repository.getAll().stream()
                .filter(user -> user.getAge() > age)
                .toList();
    }

    public double calculateAverageAge() {
        return repository.getAll().stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }


}
