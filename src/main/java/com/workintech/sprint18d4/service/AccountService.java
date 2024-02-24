package com.workintech.sprint18d4.service;

import com.workintech.sprint18d4.entity.Account;
import com.workintech.sprint18d4.entity.Customer;
import com.workintech.sprint18d4.repository.AccountRepository;
import com.workintech.sprint18d4.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
    }

    public Account createAccount(Long customerId, Account account) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
        account.setCustomer(customer);
        return accountRepository.save(account);
    }

    public Account updateAccount(Long customerId, Account accountDetails) {
        Account account = getAccountById(accountDetails.getId());
        account.setAccountName(accountDetails.getAccountName());
        account.setMoneyAmount(accountDetails.getMoneyAmount());
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
