package com.workintech.sprint18d4.controller;

import com.workintech.sprint18d4.entity.Account;
import com.workintech.sprint18d4.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok().body(account);
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<Account> createAccount(@PathVariable Long customerId, @RequestBody Account account) {
        Account createdAccount = accountService.createAccount(customerId, account);
        return ResponseEntity.ok().body(createdAccount);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long customerId, @RequestBody Account accountDetails) {
        Account updatedAccount = accountService.updateAccount(customerId, accountDetails);
        return ResponseEntity.ok().body(updatedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok().build();
    }
}
