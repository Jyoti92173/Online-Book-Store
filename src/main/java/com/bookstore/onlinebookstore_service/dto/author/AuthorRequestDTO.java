package com.bookstore.onlinebookstore_service.dto.author;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthorRequestDTO {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String authorName;
}
