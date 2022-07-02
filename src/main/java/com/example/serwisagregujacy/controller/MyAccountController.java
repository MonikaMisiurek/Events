package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.dto.AccountDTO;
import com.example.serwisagregujacy.dto.UserDTO;
import com.example.serwisagregujacy.model.Account;
import com.example.serwisagregujacy.service.MyAccountService;
import com.example.serwisagregujacy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PutMapping("/myAccount/editMyAccount")
    public RedirectView modifyEditMyAccount(@Valid Account account) {
        myAccountService.editMyAccount(account);
        return new RedirectView("/myAccount");
    }
    @PostMapping("/myAccount")
    public RedirectView postAddAccount(@PathVariable AccountDTO account){
        myAccountService.addAccount(account);
        return new RedirectView("myAccount");
    }
}
