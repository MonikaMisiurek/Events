package com.example.serwisagregujacy.repository;

import com.example.serwisagregujacy.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyAccountRepository extends JpaRepository <Account , Long> {
}
