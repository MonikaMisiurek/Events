package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.model.Account;
import com.example.serwisagregujacy.service.MyAccountService;
import com.example.serwisagregujacy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/myAccount")
public class MyAccountController {

    private final MyAccountService myAccountService;
    private final UserService userService;

    public MyAccountController(MyAccountService myAccountService, UserService userService) {
        this.myAccountService = myAccountService;
        this.userService = userService;
    }

    @GetMapping
    public String getMyAccount() {
        return ("/myAccount");
    }

    @PutMapping("/editMyAccount")
    public RedirectView modifyEditMyAccount(@Valid Account account) {
        myAccountService.editMyAccount(account);
        return new RedirectView("/myAccount");
    }


}
