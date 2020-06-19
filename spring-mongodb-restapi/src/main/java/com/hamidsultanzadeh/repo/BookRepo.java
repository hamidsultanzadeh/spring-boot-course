package com.hamidsultanzadeh.repo;

import com.hamidsultanzadeh.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends MongoRepository<Book,String> {


}
