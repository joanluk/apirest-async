package org.emaginalabs.service;


import org.emaginalabs.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Book create(Book book);
    
    Optional<Book> find(String isbn);
}