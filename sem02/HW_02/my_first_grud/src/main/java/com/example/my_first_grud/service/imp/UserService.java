package com.example.my_first_grud.service.imp;

import com.example.my_first_grud.aspect.TrackUserAction;
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

    @TrackUserAction
    public User saveUser(User user){
        return repository.save(user);
    }

    @TrackUserAction
    public void deleteById(int id) {
        repository.deleteById(id);
    }


    @TrackUserAction
    public User getUserById(int id) {
        return repository.getUserById(id);
    }

    @TrackUserAction
    public User updateUserById(User user) {
        return repository.updateUserById(user);
    }

}
