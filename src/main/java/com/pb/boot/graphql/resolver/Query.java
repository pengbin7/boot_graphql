package com.pb.boot.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pb.boot.graphql.model.Author;
import com.pb.boot.graphql.model.Book;
import com.pb.boot.graphql.repository.AuthorRepository;
import com.pb.boot.graphql.repository.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class Query implements GraphQLQueryResolver {

    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Long countBooks() {
        return bookRepository.count();
    }

    public Long countAuthors() {
        return authorRepository.count();
    }
}
