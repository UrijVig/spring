package com.example.my_first_REST.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iRepository<T> {
    List<T> getAll();
    T save(T t);
    T deleteById(int id);

    T getById(int id);

    T updateById(T user);
}
