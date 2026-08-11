package com.bookstore.onlinebookstore_service.dto.book;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookRequestDTO {

    private String title;
    private double price;
    private Integer stock;
    private Integer authorId;
    private Long categoryId;
}
