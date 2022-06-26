package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.dto.UserDTO;
import com.example.serwisagregujacy.service.UserRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;
    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }
   @GetMapping
   public String getRegistration(){
        return ("/registration/registration");
   }

    @PostMapping
    public RedirectView postAddPerson(@PathVariable UserDTO user) {
        userRegistrationService.addUser(user);
        return new RedirectView("/registration/registration");
    }


}
