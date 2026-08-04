package com.bookstore.onlinebookstore_service.repository;

import com.bookstore.onlinebookstore_service.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


}
