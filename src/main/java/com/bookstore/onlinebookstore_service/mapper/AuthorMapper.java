package com.bookstore.onlinebookstore_service.mapper;

import com.bookstore.onlinebookstore_service.dto.author.AuthorResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public static AuthorResponseDTO toResponse(Author author) {
        AuthorResponseDTO authorResponseDTO = new AuthorResponseDTO();
        authorResponseDTO.setAuthorId(author.getAuthorId());
        authorResponseDTO.setAuthorName(author.getAuthor_name());
        return authorResponseDTO;

    }
}
