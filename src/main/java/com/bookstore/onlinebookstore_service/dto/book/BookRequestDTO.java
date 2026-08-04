package com.bookstore.onlinebookstore_service.dto.book;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookRequestDTO {
    private String title;
    private String author;
    private double price;
    private String category;
}
