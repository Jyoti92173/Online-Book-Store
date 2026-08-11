package com.bookstore.onlinebookstore_service.mapper;

import com.bookstore.onlinebookstore_service.dto.book.BookRequestDTO;
import com.bookstore.onlinebookstore_service.dto.book.BookResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookResponseDTO toResponse(Book book) {

        BookResponseDTO response = new BookResponseDTO();

        response.setBookId(book.getBookId());
        response.setTitle(book.getTitle());
        response.setPrice(book.getPrice());
        response.setStock(book.getStock());

        response.setAuthor(book.getAuthor().getAuthor_name());

        response.setCategoryName(book.getCategory().getCategoryName());

        return response;
    }

}
