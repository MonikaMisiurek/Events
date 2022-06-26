package com.example.serwisagregujacy.service;

import com.example.serwisagregujacy.dto.UserDTO;
import com.example.serwisagregujacy.model.User;
import com.example.serwisagregujacy.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private final UserRepository userRepository;

    public UserRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(UserDTO user){
        User user1 = User.from(user);
//        user.toDto();
        userRepository.save(user1);
    }


}
