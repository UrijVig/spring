package com.example.my_first_grud.service.imp;

import com.example.my_first_grud.model.User;

import com.example.my_first_grud.repository.iRepository;
import com.example.my_first_grud.service.iService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserService implements iService{
    private final iRepository repository;

//    public UserService(iRepository userRepository) {
//        this.repository = userRepository;
//    }


    public List<User> findAll(){
        return repository.findAll();
    }

    public User saveUser(User user){
        return repository.save(user);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }


    public User getUserById(int id) {
        return repository.getUserById(id);
    }

    @Override
    public void updateUserById(User user) {
        repository.updateUserById(user);
    }

}
