package com.api.bookshelf.service;

import com.api.bookshelf.entity.Book;
import com.api.bookshelf.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public  List<Book> findByName(String name) {
        return repository.findByName(name);
    }
}
