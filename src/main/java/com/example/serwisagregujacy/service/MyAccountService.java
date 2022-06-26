package com.example.serwisagregujacy.service;

import com.example.serwisagregujacy.model.Account;
import com.example.serwisagregujacy.repository.MyAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class MyAccountService {
    private final MyAccountRepository myAccountRepository;


    public MyAccountService(MyAccountRepository myAccountRepository) {
        this.myAccountRepository = myAccountRepository;
    }


    public void editMyAccount(Account account){
        myAccountRepository.save(account);
    }

    // wyświetlanie eventów na które jest się zapisanym

    // wypisywanie się z events



}
