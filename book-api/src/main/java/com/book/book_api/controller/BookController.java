package com.book.book_api.controller;

import com.book.book_api.model.Book;
import com.book.book_api.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@CrossOrigin
@RestController
public class BookController {

    private BookService bookService;

    BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id){
        return new ResponseEntity<>(bookService.getBookById(id),HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(Book book){
        return new ResponseEntity<>(bookService.addBook(book),HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public  ResponseEntity<String> updateBookById(@PathVariable int id, @RequestBody Book book){
        Book book1 = bookService.getBookById(id);
        if(book1 != null){
            bookService.updateBookById(id,book);
            return new ResponseEntity<>("Updated",HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("ERROR",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id){
        Book book = bookService.getBookById(id);
        if(book != null){
            bookService.deleteBookById(id);
            return new ResponseEntity<>("DELETED", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
