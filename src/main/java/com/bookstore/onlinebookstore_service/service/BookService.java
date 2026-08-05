package com.bookstore.onlinebookstore_service.service;

import com.bookstore.onlinebookstore_service.dto.book.BookRequestDTO;
import com.bookstore.onlinebookstore_service.dto.book.BookResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Author;
import com.bookstore.onlinebookstore_service.entity.Book;
import com.bookstore.onlinebookstore_service.entity.Category;
import com.bookstore.onlinebookstore_service.repository.AuthorRepository;
import com.bookstore.onlinebookstore_service.repository.BookRepository;
import com.bookstore.onlinebookstore_service.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {
        Author author = authorRepository.findById(bookRequestDTO.getAuthorId())
                .orElseThrow(()->new RuntimeException("Author not found"));


        Category category = categoryRepository.findById(bookRequestDTO.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category not found"));

        Book book = new Book();
        book.setTitle(bookRequestDTO.getTitle());
        book.setPrice(bookRequestDTO.getPrice());
        book.setStock(bookRequestDTO.getStock());
        book.setAuthor(author);
        book.setCategory(category);

        Book savedBook= bookRepository.save(book);

        BookResponseDTO response = new BookResponseDTO();

        response.setBookId(savedBook.getBookId());
        response.setTitle(savedBook.getTitle());
        response.setPrice(savedBook.getPrice());
        response.setStock(savedBook.getStock());
        response.setAuthor(savedBook.getAuthor().getAuthor_name());
        response.setCategory(savedBook.getCategory().getCategory());

        return response;

    }
}
