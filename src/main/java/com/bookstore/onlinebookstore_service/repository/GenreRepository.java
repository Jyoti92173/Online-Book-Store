package com.bookstore.onlinebookstore_service.repository;

import com.bookstore.onlinebookstore_service.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
