package com.hamidsultanzadeh.controller;

import com.hamidsultanzadeh.entity.Book;
import com.hamidsultanzadeh.repo.BookRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepo bookRepo;

    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        return ResponseEntity.ok(bookRepo.findAll());
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookRepo.insert(book));
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> update(@PathVariable("id") String id, @RequestBody Book book){
        Book result = bookRepo.findById(id).orElse(null);

        if(result == null) return ResponseEntity.notFound().build();

        result.setAuthor(book.getAuthor());
        result.setFeatures(book.getFeatures());
        result.setName(book.getName());

        return ResponseEntity.accepted().body(bookRepo.save(result));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Book> delete(@PathVariable("id") String id){

        Book result = bookRepo.findById(id).orElse(null);

        if(result == null) return ResponseEntity.notFound().build();

        bookRepo.delete(result);

        return ResponseEntity.accepted().body(result);
    }



}
