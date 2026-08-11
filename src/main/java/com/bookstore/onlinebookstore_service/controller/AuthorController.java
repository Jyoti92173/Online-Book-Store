package com.bookstore.onlinebookstore_service.controller;

import com.bookstore.onlinebookstore_service.dto.author.AuthorRequestDTO;
import com.bookstore.onlinebookstore_service.dto.author.AuthorResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Author;
import com.bookstore.onlinebookstore_service.service.AuthorServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
