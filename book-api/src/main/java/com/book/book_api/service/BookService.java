package com.book.book_api.service;

import com.book.book_api.model.Book;
import com.book.book_api.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;

    BookService(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public  Book getBookById(int id){
        return bookRepo.findById(id).orElse(null);
    }

    public Book addBook(Book book){
        return bookRepo.save(book);
    }

    public Book updateBookById(int id, Book book) {
        if (bookRepo.existsById(id)) {
            book.setId(id);
            return bookRepo.save(book);
        } else {
            return null;
        }
    }

    public void deleteBookById(int id){
        bookRepo.deleteById(id);
    }




}