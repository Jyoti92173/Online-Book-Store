package com.bookstore.onlinebookstore_service.mapper;

import com.bookstore.onlinebookstore_service.dto.book.BookResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Author;
import com.bookstore.onlinebookstore_service.entity.Book;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BookMapper {
    public BookResponseDTO toResponse(Book book) {

        BookResponseDTO response = new BookResponseDTO();

      response.setBookId(book.getBookId());
      response.setTitle(book.getTitle());
      response.setIsbn(book.getIsbn());
      response.setDescription(book.getDescription());
      response.setPrice(book.getPrice());
      response.setStockQty(book.getStockQty());
      response.setGenre(book.getGenre().getGenreName());

      response.setAuthors(book.getAuthors()
              .stream()
              .map(author -> author.getFirstName() + " " + author.getLastName())
              .collect(Collectors.toList()));

        response.setStatus(book.getStatus());

        return response;
    }

}
