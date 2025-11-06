package com.library.service;

import com.library.model.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * this is a class to do x y z
 * and also does not
 * d e f
 */

public class Library {
    private List<Book> books;
    private String name;
    
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added: " + book.getTitle());
    }
    
    public boolean checkoutBook(String isbn, int daysToReturn) {
        Optional<Book> bookOpt = findBookByIsbn(isbn);
        if (bookOpt.isPresent() && bookOpt.get().isAvailable()) {
            Book book = bookOpt.get();
            book.setAvailable(false);
            book.setDueDate(LocalDate.now().plusDays(daysToReturn));
            System.out.println("Checked out: " + book.getTitle());
            return true;
        }
        return false;
    }
    
    public boolean returnBook(String isbn) {
        Optional<Book> bookOpt = findBookByIsbn(isbn);
        if (bookOpt.isPresent() && !bookOpt.get().isAvailable()) {
            Book book = bookOpt.get();
            book.setAvailable(true);
            book.setDueDate(null);
            System.out.println("Returned: " + book.getTitle());
            return true;
        }
        return false;
    }
    
    private Optional<Book> findBookByIsbn(String isbn) {
        return books.stream()
                   .filter(book -> book.getIsbn().equals(isbn))
                   .findFirst();
    }
    
    public List<Book> getAvailableBooks() {
        return books.stream()
                   .filter(Book::isAvailable)
                   .toList();
    }
    
    public String getName() {
        return name;
    }
}
