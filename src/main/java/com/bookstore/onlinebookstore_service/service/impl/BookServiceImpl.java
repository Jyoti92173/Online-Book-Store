package com.bookstore.onlinebookstore_service.service.impl;

import com.bookstore.onlinebookstore_service.dto.book.BookRequestDTO;
import com.bookstore.onlinebookstore_service.dto.book.BookResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Book;
import com.bookstore.onlinebookstore_service.entity.Genre;
import com.bookstore.onlinebookstore_service.mapper.BookMapper;
import com.bookstore.onlinebookstore_service.repository.BookRepository;
import com.bookstore.onlinebookstore_service.repository.GenreRepository;
import com.bookstore.onlinebookstore_service.repository.UserRepository;
import com.bookstore.onlinebookstore_service.service.BookServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookServiceInterface {

    private final BookRepository bookRepository;
    //private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookMapper bookMapper;
    private final UserRepository userRepository;

    @Override
    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {

        Genre genre = genreRepository.findById(bookRequestDTO.getGenreId())
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        Book book = new Book();

        book.setTitle(bookRequestDTO.getTitle());
        book.setIsbn(bookRequestDTO.getIsbn());
        book.setDescription(bookRequestDTO.getDescription());
        book.setPrice(bookRequestDTO.getPrice());
        book.setStockQty(bookRequestDTO.getStockQty());
        book.setGenre(genre);
        book.setStatus(bookRequestDTO.getBookStatus());

        return bookMapper.toResponse(bookRepository.save(book));

    }

    @Override
    public BookResponseDTO getById(Integer id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return bookMapper.toResponse(book);
    }


    public List<BookResponseDTO> getAllBooks() {

        return bookRepository
                .findAll()
                .stream()
                .map(bookMapper::toResponse)
                .toList();
    }
    
    public BookResponseDTO deleteBook(Integer id) {

        Book book =  bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        BookResponseDTO response = bookMapper.toResponse(book);
        bookRepository.delete(book);

        return response;
    }

    public List<BookResponseDTO> searchBooks(String title) {

        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(title);
        return books.stream()
                .map(bookMapper::toResponse)
                .toList();
    }

}


