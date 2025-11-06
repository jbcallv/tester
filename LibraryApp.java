package com.library;

import com.library.model.Book;
import com.library.service.Library;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library("Central Library");
        
        // Add some books
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("978-0596009205", "Head First Design Patterns", "Eric Freeman");
        Book book3 = new Book("978-0321356680", "Effective C++", "Scott Meyers");
        
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        
        // Test checkout and return
        System.out.println("\n--- Library Operations ---");
        library.checkoutBook("978-0134685991", 14);
        library.checkoutBook("978-0596009205", 7);
        
        System.out.println("\n--- Available Books ---");
        library.getAvailableBooks().forEach(System.out::println);
        
        System.out.println("\n--- Returning Book ---");
        library.returnBook("978-0134685991");
        
        System.out.println("\n--- Available Books After Return ---");
        library.getAvailableBooks().forEach(System.out::println);
    }
}
