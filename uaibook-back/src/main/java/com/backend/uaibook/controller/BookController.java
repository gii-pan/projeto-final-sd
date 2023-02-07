package com.backend.uaibook.controller;

import com.backend.uaibook.dto.Response;
import com.backend.uaibook.entity.Book;
import com.backend.uaibook.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public ResponseEntity<Response<Book>> createBook(@RequestBody @Valid Book book, BindingResult result) {
        Response<Book> response = new Response<>();
        if(result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
            response.setErrors(errors);

            return ResponseEntity.badRequest().body(response);
        }

        response.setData(bookService.createBook(book));
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/book")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable(name = "id") Long id, Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable(name = "id") Long id) {
        bookService.deleteBook(id);
    }
}
