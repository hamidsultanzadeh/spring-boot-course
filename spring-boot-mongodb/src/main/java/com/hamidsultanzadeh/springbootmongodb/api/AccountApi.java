package com.hamidsultanzadeh.springbootmongodb.api;

import com.hamidsultanzadeh.springbootmongodb.entity.Account;
import com.hamidsultanzadeh.springbootmongodb.service.AccountServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountApi {

    private final AccountServiceInter serviceInter;

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable String id){
        return ResponseEntity.ok(serviceInter.findById(id));
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account){
        return ResponseEntity.ok(serviceInter.save(account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> delete(@PathVariable String id){
        return ResponseEntity.ok(serviceInter.delete(id));
    }

    @GetMapping
    public ResponseEntity<List<Account>> findAll(){
        return ResponseEntity.ok(serviceInter.findAll());
    }

}
