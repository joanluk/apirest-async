package org.emaginalabs.api;

import org.emaginalabs.model.Book;
import org.emaginalabs.service.BookService;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "books")
public class BookController {

    private final BookService bookService;

    private final TaskExecutor taskExecutor;

    public BookController(BookService bookService, TaskExecutor taskExecutor) {
        this.bookService = bookService;
        this.taskExecutor = taskExecutor;
    }


    @GetMapping
    public CompletableFuture<ResponseEntity<List<Book>>> getBooks() {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok().body(bookService.findAll()), taskExecutor);
    }

}
