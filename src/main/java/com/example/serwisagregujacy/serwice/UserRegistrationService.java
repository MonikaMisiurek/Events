package com.example.serwisagregujacy.serwice;

import com.example.serwisagregujacy.model.User;
import com.example.serwisagregujacy.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private final UserRepository userRepository;

    public UserRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        userRepository.save(user);
    }
}
