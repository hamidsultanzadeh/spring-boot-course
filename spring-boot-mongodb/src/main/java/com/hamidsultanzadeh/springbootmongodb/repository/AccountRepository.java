package com.hamidsultanzadeh.springbootmongodb.repository;

import com.hamidsultanzadeh.springbootmongodb.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account,String> {
}
