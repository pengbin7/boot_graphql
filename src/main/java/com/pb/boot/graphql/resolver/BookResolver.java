package com.pb.boot.graphql.resolver;


import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pb.boot.graphql.model.Author;
import com.pb.boot.graphql.model.Book;
import com.pb.boot.graphql.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class BookResolver implements GraphQLResolver<Book> {

    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }

    public String a(Book book) {
        return book.getTitle()+"Hello";
    }
}
