package com.hamidsultanzadeh.springbootmongodb.service;

import com.hamidsultanzadeh.springbootmongodb.entity.Account;
import com.hamidsultanzadeh.springbootmongodb.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountServiceInter {

    private final AccountRepository accountRepository;

    @Override
    public Account findById(String id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account save(Account account) {
        account.setId(UUID.randomUUID().toString());
        return accountRepository.save(account);
    }

    @Override
    public Account delete(String id) {
        Account account = accountRepository.findById(id).orElse(null);
        if(account == null) return null;
        accountRepository.delete(account);
        return account;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
