package com.bookstore.onlinebookstore_service.service;

import com.bookstore.onlinebookstore_service.dto.book.BookRequestDTO;
import com.bookstore.onlinebookstore_service.dto.book.BookResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Book;

import java.util.List;

public interface BookServiceInterface {
    BookResponseDTO createBook(BookRequestDTO bookRequestDTO);

    BookResponseDTO getById(Integer id);
    List<BookResponseDTO> getAllBooks();
    BookResponseDTO updateBook(Integer id, BookRequestDTO bookRequestDTO);

}
