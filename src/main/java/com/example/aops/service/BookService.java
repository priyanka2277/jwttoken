package com.example.aops.service;

import com.example.aops.model.Book;
import com.example.aops.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book createBook(Book book){
        return bookRepository.save(book);
    }
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }
    public Book updateBook(Long id,Book bookDetails){
        return bookRepository.findById(id).map(book->{
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            return bookRepository.save(book);
        }).orElseThrow(()-> new RuntimeException("Book not found"));
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }


}
