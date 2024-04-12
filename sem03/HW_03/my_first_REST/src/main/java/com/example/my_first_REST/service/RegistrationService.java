package com.example.my_first_REST.service;

import com.example.my_first_REST.domen.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public void processRegistration(User user) {
        dataProcessingService.addUser(user);
        userService.createUser(user);
        notificationService.sendNotification("Пользователь успешьно зарегистрирован!");
    }
}
