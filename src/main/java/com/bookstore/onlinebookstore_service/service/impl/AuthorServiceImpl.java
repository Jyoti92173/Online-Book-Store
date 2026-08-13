package com.bookstore.onlinebookstore_service.service.impl;

import com.bookstore.onlinebookstore_service.dto.author.AuthorRequestDTO;
import com.bookstore.onlinebookstore_service.dto.author.AuthorResponseDTO;
import com.bookstore.onlinebookstore_service.dto.book.BookResponseDTO;
import com.bookstore.onlinebookstore_service.entity.Author;
import com.bookstore.onlinebookstore_service.mapper.AuthorMapper;
import com.bookstore.onlinebookstore_service.repository.AuthorRepository;
import com.bookstore.onlinebookstore_service.service.AuthorServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorServiceInterface {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorResponseDTO createAuthor(AuthorRequestDTO request) {

        Author author = new Author();

        author.setAuthor_name(request.getAuthorName());

        Author savedAuthor = authorRepository.save(author);

        return AuthorMapper.toResponse(savedAuthor);

    }

    @Override
    public AuthorResponseDTO getById(Integer id ){
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Author not found"));
        return AuthorMapper.toResponse(author);

    }

    @Override
    public List<AuthorResponseDTO> getAllAuthors() {

        return authorRepository.findAll()
                .stream()
                .map(AuthorMapper::toResponse)
                .toList();
    }

    @Override
    public AuthorResponseDTO updateAuthors(Integer id, AuthorRequestDTO request) {

        Author  author = authorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Author not found"));
        author.setAuthor_name(request.getAuthorName());
        Author savedAuthor = authorRepository.save(author);
        return AuthorMapper.toResponse(savedAuthor);

    }

    @Override
    public AuthorResponseDTO deleteAuthor(Integer id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Author not found"));

        AuthorResponseDTO response = AuthorMapper.toResponse(author);
        authorRepository.delete(author);


        return response;

    }

    @Override
    public AuthorResponseDTO searchAuthor(Integer id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Author not found"));

        return AuthorMapper.toResponse(author);

    }


}
