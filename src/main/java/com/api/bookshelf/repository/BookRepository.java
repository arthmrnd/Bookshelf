package com.api.bookshelf.repository;

import com.api.bookshelf.entity.Book;
import com.api.bookshelf.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByIsbn(String isbn);
    List<Book> findByCategory(Category category);
    List<Book> findByIsAvailable(Boolean isAvailable);
}
