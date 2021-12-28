package com.api.bookshelf.controller;

import com.api.bookshelf.entity.Book;
import com.api.bookshelf.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/name")
    public List<Book> listByName(@RequestBody String name) {
        return service.findByName(name);
    }


}
