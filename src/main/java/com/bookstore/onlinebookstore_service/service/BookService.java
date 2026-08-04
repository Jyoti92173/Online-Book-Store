package com.bookstore.onlinebookstore_service.service;

import com.bookstore.onlinebookstore_service.dto.book.BookRequestDTO;
import com.bookstore.onlinebookstore_service.dto.book.BookResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Book;
import com.bookstore.onlinebookstore_service.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {
        Book book = new Book();
        book.setTitle(book.getTitle());
        book.setAuthor(book.getAuthor());
        book.setPrice(book.getPrice());
        book.setCategory(book.getCategory());

        Book savedBook= bookRepository.save(book);

        BookResponseDTO response = new BookResponseDTO();

        response.setId(savedBook.getBookId());
        response.setTitle(savedBook.getTitle());
        response.setAuthor(savedBook.getAuthor());
        response.setPrice(savedBook.getPrice());

        return response;

    }
}
