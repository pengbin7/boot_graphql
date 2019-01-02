package com.pb.boot.graphql.repository;

import com.pb.boot.graphql.model.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorRepository {

    public Iterable<Author> findAll() {
        List<Author> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Author("Gosling","James"));
        }
        return list;
    }

    public long count() {
        return 0;
    }

    public void save(Author author) {
        System.out.println(author.getFirstName()+author.getLastName() + " was saved!");
    }

    public Author findOne(Long id) {
        return new Author("Gosling","James");
    }
}
