package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.model.User;
import com.example.serwisagregujacy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
    public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping
        public String getUsers() {
            return ("/users/users");
        }

        @GetMapping("/editUsers/{id}")
        public String getEditUser(@PathVariable Long id, Model model) {
            User user = userService.getUserById(id);
            model.addAttribute("user", user);
            return ("/users/editUser");
        }
        @PutMapping("/{id}")
        public RedirectView modifyUser(@Valid User user, @PathVariable Long id) {
            userService.editUser(user);
            return new RedirectView("/user/editUser");
        }

        @DeleteMapping("/{id}")
        public RedirectView deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
            return new RedirectView("/user/deleteUser");
        }
    }

