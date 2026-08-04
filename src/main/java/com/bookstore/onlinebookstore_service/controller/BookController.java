package com.bookstore.onlinebookstore_service.controller;

import com.bookstore.onlinebookstore_service.dto.book.BookRequestDTO;
import com.bookstore.onlinebookstore_service.dto.book.BookResponseDTO;
import com.bookstore.onlinebookstore_service.repository.BookRepository;
import com.bookstore.onlinebookstore_service.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Books")
@RequiredArgsConstructor
public class BookController {

    private BookService bookService;
    @PostMapping("/create")
    public ResponseEntity<BookRequestDTO> CreateBook(@RequestBody BookRequestDTO bookRequestDTO){
        BookResponseDTO  bookResponse =
                bookService.createBook(bookRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookRequestDTO);
    }
}
