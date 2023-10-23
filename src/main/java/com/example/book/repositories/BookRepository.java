package com.example.book.repositories;

import com.example.book.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book getBookById(Long id);
}
