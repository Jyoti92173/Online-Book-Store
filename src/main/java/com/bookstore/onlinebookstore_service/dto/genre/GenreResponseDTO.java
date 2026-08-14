package com.bookstore.onlinebookstore_service.dto.genre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GenreResponseDTO {

    private Integer genreId;
    private String genreName;
}
