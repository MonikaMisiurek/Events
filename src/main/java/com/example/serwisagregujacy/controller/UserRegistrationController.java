package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.model.User;
import com.example.serwisagregujacy.serwice.UserRegistrationService;
import com.example.serwisagregujacy.serwice.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;
    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }
   @GetMapping ("/registration")
   public String getRegistration(){
        return ("/registration/registration");
   }

    @PostMapping("/registration")
    public RedirectView postAddPerson(@PathVariable User user) {
        userRegistrationService.addUser(user);
        return new RedirectView("/registration/registration");
    }


}
