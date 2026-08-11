package com.bookstore.onlinebookstore_service.repository;

import com.bookstore.onlinebookstore_service.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
