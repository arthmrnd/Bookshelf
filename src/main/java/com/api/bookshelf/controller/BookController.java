package com.api.bookshelf.controller;

import com.api.bookshelf.entity.Book;
import com.api.bookshelf.enums.Category;
import com.api.bookshelf.request.BookRequest;
import com.api.bookshelf.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping("/All")
    public List<Book> listAll() {
        return service.findAll();
    }

    @GetMapping("/title")
    public List<Book> listByName(@RequestBody String title) {
        return service.findByTitle(title);
    }

    @GetMapping("/author")
    public List<Book> listByAuthor(@RequestBody String author) {
        return service.findByAuthor(author);
    }

    @GetMapping("/isbn")
    public List<Book> listByIsbn(@RequestBody String isbn) {
        return service.findByIsbn(isbn);
    }

    @GetMapping("/category")
    public List<Book> listByCategory(@RequestBody Category category) {
        return service.findByCategory(category);
    }

    @GetMapping("/availability")
    public List<Book> listByIsAvailable(@RequestBody Boolean isAvailable) {
        return service.findByIsAvailable(isAvailable);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody BookRequest book) {
        return service.addBook(book);
    }

    @PutMapping("/getbook")
    public Book getBook(@RequestBody String idBook) {
        return service.getBook(idBook);
    }

    @PutMapping("/putbook")
    public Book putBook(@RequestBody String idBook) {
        return service.putBook(idBook);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        service.deleteBook(id);
    }

}
