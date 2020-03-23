package com.hamidsultanzadeh.springbootmongodb.service;

import com.hamidsultanzadeh.springbootmongodb.entity.Account;

import java.util.List;

public interface AccountServiceInter {

    Account findById(String id);

    Account save(Account account);

    Account delete(String id);

    List<Account> findAll();

}
