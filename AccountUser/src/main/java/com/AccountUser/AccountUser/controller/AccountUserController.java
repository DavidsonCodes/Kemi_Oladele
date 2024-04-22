package com.AccountUser.AccountUser.controller;

import com.AccountUser.AccountUser.model.AccountUser;
import com.AccountUser.AccountUser.service.AccountUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AccountUser")
public class AccountUserController {

    private final AccountUserService accountUserService;

    public AccountUserController(AccountUserService accountUserService) {
        this.accountUserService = accountUserService;
    }

    @GetMapping("/allAccountUser")
    public ResponseEntity<List<AccountUser>>getAllAccountUser(){
        return accountUserService.getAllAccountUser();
    }
    @GetMapping("/single/{id}")
    public ResponseEntity<AccountUser>getAccountUserById(@PathVariable int id){
        return accountUserService.getAccountUserById(id);
    }
    @GetMapping("/username")
    public ResponseEntity<AccountUser>getAccountUserByUsername(@PathVariable String username){
        return accountUserService.getAccountUserByUsername(username);
    }

    @PostMapping("/single")
    public ResponseEntity<AccountUser>addNewAccountUser(@RequestBody @Valid AccountUser accountUser){
        return accountUserService.addNewAccountUser(accountUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AccountUser>updateAccountUser(@PathVariable int id, @Valid @RequestBody AccountUser accountUser){
        return accountUserService.updateAccountUser(id, accountUser);
    }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<AccountUser>deleteAccountUser(@PathVariable int id){
        return accountUserService.deleteAccountUser(id);
   }
}
