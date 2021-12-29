package com.api.bookshelf.service;

import com.api.bookshelf.entity.Book;
import com.api.bookshelf.enums.Category;
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

    public List<Book> findByTitle(String title) {
        return repository.findByTitle(title);
    }

    public List<Book> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public List<Book> findByIsbn(String isbn) {
        return repository.findByIsbn(isbn);
    }

    public List<Book> findByCategory(Category category) {
        return repository.findByCategory(category);
    }

    public List<Book> findByIsAvailable(Boolean isAvailable) {
        return repository.findByIsAvailable(isAvailable);
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public void deleteBook(Long idBook) {
        repository.deleteById(idBook);
    }





}
