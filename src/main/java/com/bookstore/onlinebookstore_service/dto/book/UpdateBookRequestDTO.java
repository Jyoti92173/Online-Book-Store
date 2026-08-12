package com.bookstore.onlinebookstore_service.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateBookRequestDTO {
    private String title;
    private String author;
    private double price;
    private String category;
}
