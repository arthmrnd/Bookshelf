package com.api.bookshelf.service;

import com.api.bookshelf.entity.Book;
import com.api.bookshelf.enums.Category;
import com.api.bookshelf.exception.BookAlreadyInBookshelf;
import com.api.bookshelf.exception.BookIsntAvailableException;
import com.api.bookshelf.exception.BookNotFoundException;
import com.api.bookshelf.repository.BookRepository;
import com.api.bookshelf.request.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public Book findById(String id) {
        var optBook = repository.findById(id);
        if (optBook.isPresent()) return optBook.get();
        else throw new BookNotFoundException(id);

    }

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

    public Book addBook(BookRequest request) {
        var book = request.converter();
        return saveBook(book);
    }

    private Book saveBook(Book book) {
        return repository.save(book);
    }

    public Book getBook(String idBook) {
        var book = findById(idBook);
        if (book.getIsAvailable().equals(true)) {
            book.setIsAvailable(false);
            return saveBook(book);
        }
        else throw new BookIsntAvailableException(book.getTitle());
    }

    public Book putBook(String idBook) {
        var book = findById(idBook);
        if (book.getIsAvailable().equals(false)) {
            book.setIsAvailable(true);
            return saveBook(book);
        }
        else throw new BookAlreadyInBookshelf(book.getTitle());
    }

    public void deleteBook(String idBook) {
        repository.deleteById(idBook);
    }





}
