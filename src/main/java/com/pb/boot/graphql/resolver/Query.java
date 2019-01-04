package com.pb.boot.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pb.boot.graphql.exception.BookNotFoundException;
import com.pb.boot.graphql.model.Author;
import com.pb.boot.graphql.model.Book;
import com.pb.boot.graphql.repository.AuthorRepository;
import com.pb.boot.graphql.repository.BookRepository;
import com.pb.boot.model.domain.User;
import com.pb.boot.model.query.UserQuery;
import com.pb.boot.model.vo.UserVo;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Query implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
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
        int count = 1;
        if(count == 1){
            throw new BookNotFoundException("查询出错了...",new Long(1));
        }
        return bookRepository.count();
    }

    public Long countAuthors() {
        return authorRepository.count();
    }

    public Book getOneBook(){
        return new Book("小王子", "hello",1, new Author());
    }

    public User getOneUser(){
        User u = new User();
        u.setName("孙悟空");
        return u;
    }

    public UserVo test(UserQuery name){
        UserVo u = new UserVo();
        u.setName("孙悟空");
        u.setPassword(name.getPassword());
        return u;
    }

}
