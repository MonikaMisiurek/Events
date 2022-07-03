package com.example.serwisagregujacy.service;

import com.example.serwisagregujacy.dto.UserDTO;
import com.example.serwisagregujacy.model.Account;
import com.example.serwisagregujacy.model.User;
import com.example.serwisagregujacy.model.UserLevel;
import com.example.serwisagregujacy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        //this.accountService = accountService;
    }

    public void editUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        System.out.println("Usunięcie osoby o id" + id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void createUser(UserDTO user) {
        User user1 = User.from(user);
        user1.toDto();
        userRepository.save(user1);
       // var user1 = User.from(user);
       // var saved = userRepository.save(user1);
       // var user2 = new User(saved.getId(), saved.getName(), saved.getPassword(), saved.getEmail(), UserLevel.USER, saved.getEvents());
        //accountService.addAccount(ff);
    }
// napisana nowa
//    public void createUser(User user){
//        userRepository.save(user);
//
//    }


}
