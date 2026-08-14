package com.bookstore.onlinebookstore_service.entity;

import com.bookstore.onlinebookstore_service.enums.BookStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    private String title;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;

    @Column(name = "stock_qty")
    private Integer stockQty;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private BookStatus status;
}
