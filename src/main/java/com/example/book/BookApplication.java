package com.example.book;

import com.example.book.entities.Book;
import com.example.book.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BookRepository bookRepository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                Book book = new Book();
                book.setId(null);
                book.setTitle("Book" + i);
                book.setPrice(Math.random() * 200);
                bookRepository.save(book);
            }

            List<Book> books = bookRepository.findAll();

            books.forEach(book -> {
                System.out.println(book.toString());
            });
        };
    }

}
