package com.bookstore.onlinebookstore_service.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDTO {

    private Integer authorId;
    private String authorName;
}
