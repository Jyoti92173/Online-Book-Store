package com.bookstore.onlinebookstore_service.service.impl;

import com.bookstore.onlinebookstore_service.dto.book.BookRequestDTO;
import com.bookstore.onlinebookstore_service.dto.book.BookResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Author;
import com.bookstore.onlinebookstore_service.entity.Book;
import com.bookstore.onlinebookstore_service.entity.Category;
import com.bookstore.onlinebookstore_service.mapper.BookMapper;
import com.bookstore.onlinebookstore_service.repository.AuthorRepository;
import com.bookstore.onlinebookstore_service.repository.BookRepository;
import com.bookstore.onlinebookstore_service.repository.CategoryRepository;
import com.bookstore.onlinebookstore_service.service.BookServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookServiceInterface {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookMapper bookMapper;


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

    @Override
    public BookResponseDTO updateBook(Integer id,
                                      BookRequestDTO bookRequestDTO) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Author author = authorRepository.findById(bookRequestDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Category category = categoryRepository.findById(bookRequestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        book.setTitle(bookRequestDTO.getTitle());
        book.setPrice(bookRequestDTO.getPrice());
        book.setStock(bookRequestDTO.getStock());
        book.setAuthor(author);
        book.setCategory(category);
        book.setAuthorName(author.getAuthor_name());
        book.setCategoryName(category.getCategoryName());

        return bookMapper.toResponse(bookRepository.save(book));
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


