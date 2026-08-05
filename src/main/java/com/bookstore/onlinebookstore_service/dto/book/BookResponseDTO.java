package com.bookstore.onlinebookstore_service.dto.book;


import lombok.Data;

@Data
public class BookResponseDTO {

    private Long  bookId;
    private String title;

    private Double price;
    private Integer stock;

    private String author;
    private String category;

}
