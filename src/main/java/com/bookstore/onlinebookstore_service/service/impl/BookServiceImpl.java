package com.bookstore.onlinebookstore_service.service.impl;

import com.bookstore.onlinebookstore_service.dto.book.BookRequestDTO;
import com.bookstore.onlinebookstore_service.dto.book.BookResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Author;
import com.bookstore.onlinebookstore_service.entity.Book;
import com.bookstore.onlinebookstore_service.entity.Category;
import com.bookstore.onlinebookstore_service.repository.AuthorRepository;
import com.bookstore.onlinebookstore_service.repository.BookRepository;
import com.bookstore.onlinebookstore_service.repository.CategoryRepository;
import com.bookstore.onlinebookstore_service.service.BookServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookServiceInterface {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {

        Author author = authorRepository.findById(bookRequestDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Category category = categoryRepository.findById(bookRequestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Book book = new Book();

        book.setTitle(bookRequestDTO.getTitle());
        book.setPrice(bookRequestDTO.getPrice());
        book.setStock(bookRequestDTO.getStock());

        book.setAuthor(author);
        book.setCategory(category);

        book.setAuthorName(author.getAuthor_name());
        book.setCategoryName(category.getCategoryName());

        Book savedBook = bookRepository.save(book);

        BookResponseDTO response = new BookResponseDTO();

        response.setBookId(savedBook.getBookId());
        response.setTitle(savedBook.getTitle());
        response.setPrice(savedBook.getPrice());
        response.setStock(savedBook.getStock());

        response.setAuthor(savedBook.getAuthor().getAuthor_name());
        response.setCategoryName(savedBook.getCategory().getCategoryName());

        return response;
    }

    @Override
    public BookResponseDTO getById(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        BookResponseDTO response = new BookResponseDTO();

        response.setBookId(book.getBookId());
        response.setTitle(book.getTitle());
        response.setPrice(book.getPrice());
        response.setStock(book.getStock());

        response.setAuthor(book.getAuthor().getAuthor_name());
        response.setCategoryName(book.getCategory().getCategoryName());

        return response;
    }
}