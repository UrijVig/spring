package com.example.my_first_REST.service;

import com.example.my_first_REST.domen.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private NotificationService notificationService;

    //    public UserService(NotificationService notificationService) {
    //        this.notificationService = notificationService;
    //    }

    public User createUser(User user) {
        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);
        return user;
    }
}
