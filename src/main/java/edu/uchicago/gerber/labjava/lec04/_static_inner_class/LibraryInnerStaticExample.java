package edu.uchicago.gerber.labjava.lec04._static_inner_class;

import java.util.ArrayList;
import java.util.List;

public class LibraryInnerStaticExample {
    // Static inner class representing a Book
    public static class Book {
        private String title;
        private String author;

        // Constructor
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

    // Method in the outer class to demonstrate usage of the static inner class
    public static void main(String[] args) {

        //notice that I do not need an instance of LibraryInnerStaticExample to construct a book.
        //I get all the benefits of encapsulating the Book class in a one file, and yet it behaves like a class defined
        // in a separate file (Top Level class).

        List<LibraryInnerStaticExample.Book> arrayList = new ArrayList<>();
        arrayList.add(new LibraryInnerStaticExample.Book("1984", "George Orwell"));
        arrayList.add(new LibraryInnerStaticExample.Book("To Kill a Mockingbird", "Harper Lee"));


        // Displaying book details
        System.out.println("Library Books:");
        arrayList.forEach(book -> System.out.println(book));


    }
}
