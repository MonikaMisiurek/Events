package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.dto.UserDTO;
import com.example.serwisagregujacy.model.User;
import com.example.serwisagregujacy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // wyświetla profil
    @GetMapping("/user")
    public String getUsers() {
        return ("/user");
    }

    // wyświetla formuarz rejestracyjny
    @GetMapping("/registration")
    public ModelAndView getRegistration(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        modelAndView.addObject("newUser", new UserDTO(0L, "", "", "", Set.of()));
        return modelAndView;
    }

    // powinna dodawać uzytkownika
    @PostMapping("/registration")
    public String createUser(@ModelAttribute UserDTO user) {
        userService.createUser(user);
        return "redirect:/";
    }


    // po co nam to?
    @GetMapping("/user/{id}")
    public String getEditUser(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return ("/users/editUser");
    }

    // modyfikacja usera
    @PutMapping("/user/{id}")
    public RedirectView modifyUser(@Valid User user, @PathVariable Long id) {
        userService.editUser(user);
        return new RedirectView("/user/editUser");
    }

    //usunięcie usera
    @DeleteMapping("/user/{id}")
    public RedirectView deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new RedirectView("/user/deleteUser");
    }


}

