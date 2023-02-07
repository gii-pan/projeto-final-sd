package com.backend.uaibook.service;

import com.backend.uaibook.entity.Book;
import com.backend.uaibook.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksFromUser(String cpf) {
        return null;
    }

    public Book updateBook(Long id, Book book) {
        Book bookSaved = bookRepository.getBookById(id);

        if(bookSaved == null)
            throw  new NullPointerException("Book not found");

        if(book.getName() != null)
            bookSaved.setName(book.getName());

        if(book.getCategories() != null)
            bookSaved.setCategories(book.getCategories());

        if(book.getAmount() != null)
            bookSaved.setAmount(book.getAmount());

        if(book.getYear() != null)
            bookSaved.setYear(book.getYear());

        return bookRepository.save(bookSaved);
    }

    public void deleteBook(Long id) {
        Book bookSaved = bookRepository.getBookById(id);

        if(bookSaved == null)
            throw  new NullPointerException("Book not found");

        bookRepository.delete(bookSaved);
    }
}
