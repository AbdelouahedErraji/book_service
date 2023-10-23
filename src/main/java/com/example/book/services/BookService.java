package com.example.book.services;

import com.example.book.models.BookRequest;
import com.example.book.models.BookResponse;

import java.util.List;

public interface BookService {
    BookResponse getOneBook(Long id);
    List<BookResponse> getAllBooks();
    BookResponse addBook(BookRequest bookRequest);
}
