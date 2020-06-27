package com.hamidsultanzadeh.controller;

import com.hamidsultanzadeh.entity.Book;
import com.hamidsultanzadeh.repo.BookRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepo bookRepo;

    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @PostConstruct
    public void init(){
        Book b1 = new Book();
        b1.setId("id1");
        b1.setName("Java 1");
        b1.setAuthor("Hamid");
        b1.setDescription("Java haqqinda her shey !!");
        b1.setPrice(22.0);

        Book b2 = new Book();
        b2.setId("id2");
        b2.setName("Java-da OOP");
        b2.setAuthor("Hamid Sultanzadeh");
        b2.setDescription("Java-da OOP tetbiqi");
        b2.setPrice(25.0);

        bookRepo.save(b1); bookRepo.save(b2);
    }

    @GetMapping("/by/id/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") String id){
        Optional<Book> opt = bookRepo.findById(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Book>> findBySearchQuery(@PathVariable("search") String search){
//        List<Book> books = bookRepo.findCustomQuery(search);
        List<Book> books = bookRepo.findAllByNameLikeOrAuthorLikeOrDescriptionLike(search,search,search);
        return ResponseEntity.ok(books);
    }
}
