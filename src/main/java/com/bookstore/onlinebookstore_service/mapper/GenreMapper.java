package com.bookstore.onlinebookstore_service.mapper;

import com.bookstore.onlinebookstore_service.dto.genre.GenreResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Genre;

public class GenreMapper {
    public GenreResponseDTO toResponse(Genre genre) {

        GenreResponseDTO response = new GenreResponseDTO();
        response.setGenreId(genre.getGenreId());
        response.setGenreName(genre.getGenreName());
        return response;
    }
}
