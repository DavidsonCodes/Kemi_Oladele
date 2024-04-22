package com.AccountUser.AccountUser.service;

import com.AccountUser.AccountUser.model.AccountUser;
import com.AccountUser.AccountUser.repository.AccountUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUserService {
    private AccountUserRepository accountUserRepository;

    public ResponseEntity<List<AccountUser>> getAllAccountUser(){
        return new ResponseEntity<>(accountUserRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<AccountUser> getAccountUserById(int id){
        return new ResponseEntity<>(accountUserRepository.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<AccountUser> getAccountUserByUsername(String username){
        return new ResponseEntity<>(accountUserRepository.findByUsername(username), HttpStatus.OK);
    }

    public ResponseEntity<AccountUser> addNewAccountUser(AccountUser accountUser){
        return new ResponseEntity<>(accountUserRepository.save(accountUser), HttpStatus.CREATED);
    }

    public ResponseEntity<AccountUser> updateAccountUser(int id, AccountUser accountUser){
        AccountUser dbAccountuser = accountUserRepository.findById(id).get();
        dbAccountuser.setFirstName(accountUser.getFirstName());
        dbAccountuser.setLastName(accountUser.getLastName());
        dbAccountuser.setMiddleName(accountUser.getMiddleName());
        dbAccountuser.setUsername(accountUser.getUsername());
        dbAccountuser.setPassword(accountUser.getPassword());
        dbAccountuser.setPhoneNumber(accountUser.getPhoneNumber());
        return new ResponseEntity<>(accountUserRepository.save(dbAccountuser), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<AccountUser> deleteAccountUser(int id){
        AccountUser accountUser = accountUserRepository.findById(id).get();
        accountUserRepository.deleteById(id);
        return new ResponseEntity<>(accountUser, HttpStatus.OK);
    }




}
