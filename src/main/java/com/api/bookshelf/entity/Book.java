package com.api.bookshelf.entity;

import com.api.bookshelf.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id_book")
    private String idBook;
    private String title;
    private String author;
    private String isbn;
    private String year;
    private Category category;
    private Boolean isAvailable;

}
