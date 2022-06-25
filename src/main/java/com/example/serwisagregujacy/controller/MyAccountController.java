package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.model.Account;
import com.example.serwisagregujacy.serwice.MyAccountService;
import com.example.serwisagregujacy.serwice.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class MyAccountController {

    private final MyAccountService myAccountService;
    private final UserService userService;

    public MyAccountController(MyAccountService myAccountService, UserService userService) {
        this.myAccountService = myAccountService;
        this.userService = userService;
    }



    @GetMapping("/myAccount")
    public String getMyAccount() {
        return ("/myAccount");
    }

    @PostMapping("/editMyAccount")
    public RedirectView postEditMyAccount(@Valid Account account) {
        myAccountService.editMyAccount(account);
        return new RedirectView("/myAccount");
    }


}
