package com.bookstore.onlinebookstore_service.service;

import com.bookstore.onlinebookstore_service.dto.author.AuthorRequestDTO;
import com.bookstore.onlinebookstore_service.dto.author.AuthorResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorServiceInterface {

    AuthorResponseDTO createAuthor(AuthorRequestDTO request);
}
