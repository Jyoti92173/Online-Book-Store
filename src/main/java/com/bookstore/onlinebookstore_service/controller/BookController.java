package com.bookstore.onlinebookstore_service.controller;

import com.bookstore.onlinebookstore_service.dto.book.BookRequestDTO;
import com.bookstore.onlinebookstore_service.dto.book.BookResponseDTO;
import com.bookstore.onlinebookstore_service.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookServiceImpl bookService;

    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(
            @RequestBody BookRequestDTO bookRequestDTO) {

        BookResponseDTO response = bookService.createBook(bookRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Integer id){
        BookResponseDTO response = bookService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){

        List<BookResponseDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<BookResponseDTO> deleteBook(@PathVariable Integer id){
        BookResponseDTO response  = bookService.deleteBook(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookResponseDTO>> searchBooks(@RequestParam String title){

         return ResponseEntity.ok(bookService.searchBooks(title));
    }

}