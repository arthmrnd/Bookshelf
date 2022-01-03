package com.api.bookshelf.request;

import com.api.bookshelf.entity.Book;
import com.api.bookshelf.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequest {
    private String title;
    private String author;
    private String isbn;
    private String year;
    private Category category;

    public Book converter() {
        return Book.builder()
                .idBook(UUID.randomUUID().toString())
                .title(this.getTitle())
                .author(this.getAuthor())
                .isbn(this.getIsbn())
                .year(this.getYear())
                .category(this.getCategory())
                .isAvailable(true)
                .build();
    }
}
