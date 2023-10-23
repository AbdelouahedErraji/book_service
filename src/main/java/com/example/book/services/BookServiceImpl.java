package com.example.book.services;

import com.example.book.entities.Book;
import com.example.book.models.BookRequest;
import com.example.book.models.BookResponse;
import com.example.book.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public BookResponse getOneBook(Long id) {
        Book book = bookRepository.getBookById(id);
        BookResponse bookRes = new BookResponse(book);
        return bookRes;
    }

    @Override
    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookResponse> bookRes = new ArrayList<>();
        books.forEach(book -> {
            bookRes.add(new BookResponse(book));
        });
        return bookRes;
    }

    @Override
    public BookResponse addBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        bookRepository.save(book);
        return new BookResponse(book);
    }
}
