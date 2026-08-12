package com.bookstore.onlinebookstore_service.controller;

import com.bookstore.onlinebookstore_service.dto.author.AuthorRequestDTO;
import com.bookstore.onlinebookstore_service.dto.author.AuthorResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Author;
import com.bookstore.onlinebookstore_service.service.AuthorServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor

public class AuthorController {

    private final AuthorServiceInterface  authorService;

    @PostMapping
    public ResponseEntity<AuthorResponseDTO> createAuthor(
            @RequestBody AuthorRequestDTO request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authorService.createAuthor(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable Integer id) {
        AuthorResponseDTO response = authorService.getById(id);
        return  ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<List<AuthorResponseDTO>> getAllAuthor() {

        List<AuthorResponseDTO> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);


    }
    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> updateAuthor(
            @PathVariable Integer id,
            @RequestBody AuthorRequestDTO request
    ) {
        AuthorResponseDTO response = authorService.updateAuthors(id,request);
        return  ResponseEntity.ok(response);
    }



}
