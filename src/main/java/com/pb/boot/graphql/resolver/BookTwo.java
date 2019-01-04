package com.pb.boot.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pb.boot.graphql.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookTwo implements GraphQLResolver<Book> {

    public String b(Book book){
        return book.getTitle()+"World";
    }
}
