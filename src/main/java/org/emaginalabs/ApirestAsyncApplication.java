package org.emaginalabs;

import org.emaginalabs.model.Book;
import org.emaginalabs.service.BookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ApirestAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApirestAsyncApplication.class, args);
    }


    @Bean
    public ApplicationRunner booksInitializer(BookService bookService) {
        return args -> {
            bookService.create(Book.builder().isbn("9780061120084").title("To Kill a Mockingbird").authors(Arrays.asList("Harper Lee")).build());
            bookService.create(Book.builder().isbn("9780451524935").title("1984").authors(Arrays.asList("George Orwell")).build());
            bookService.create(Book.builder().isbn("9780618260300").title("The Hobbit").authors(Arrays.asList("J.R.R. Tolkien")).build());
        };
    }
}

