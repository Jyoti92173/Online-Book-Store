package com.bookstore.onlinebookstore_service.service;

import com.bookstore.onlinebookstore_service.dto.book.BookRequestDTO;
import com.bookstore.onlinebookstore_service.dto.book.BookResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Book;

public interface BookServiceInterface {
    BookResponseDTO createBook(BookRequestDTO bookRequestDTO);

    BookResponseDTO getById(Long id);
}
