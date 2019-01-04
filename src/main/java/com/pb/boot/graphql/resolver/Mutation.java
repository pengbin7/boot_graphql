package com.pb.boot.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pb.boot.graphql.exception.BookNotFoundException;
import com.pb.boot.graphql.model.Author;
import com.pb.boot.graphql.model.Book;
import com.pb.boot.graphql.repository.AuthorRepository;
import com.pb.boot.graphql.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class Mutation implements GraphQLMutationResolver {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorRepository.save(author);
        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);
        bookRepository.save(book);
        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findOne(id);
        if(book == null) {
            throw new BookNotFoundException("The book to be updated was found", id);
        }
        book.setPageCount(pageCount);
        bookRepository.save(book);
        return book;
    }
}