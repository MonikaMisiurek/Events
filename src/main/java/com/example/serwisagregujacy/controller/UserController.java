package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.model.User;
import com.example.serwisagregujacy.serwice.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

    @Controller
    public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }
        @GetMapping("/users")
        public String getUsers() {
            return ("/users/users");
        }
        @GetMapping("/editUsers/{id}")
        public String getEditUser(@PathVariable Long id, Model model) {
            User user = userService.getUserById(id);
            model.addAttribute("user", user);
            return ("/user/editUser");
        }

        @PostMapping("/editUser/{id}")
        public RedirectView postEditUser(User user, @PathVariable Long id) {
            userService.editUser(user);
            return new RedirectView("/user/editUser");
        }

        @PostMapping("/delete/{id}")
        public RedirectView deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
            return new RedirectView("/user/deleteUser");
        }
    }

