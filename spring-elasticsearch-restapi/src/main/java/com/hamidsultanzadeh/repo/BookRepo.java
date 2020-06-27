package com.hamidsultanzadeh.repo;

import com.hamidsultanzadeh.entity.Book;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends ElasticsearchRepository<Book,String> {

    @Query("{\"bool\":{\"must\":[{\"match\":{\"name\":\"?0\"}}]}}")
    List<Book> findCustomQuery(String search);

    List<Book> findAllByNameLikeOrAuthorLikeOrDescriptionLike(String name, String author, String description);
}
