package edu.uchicago.gerber.labjava.lec04._static_inner_class;

import java.util.ArrayList;
import java.util.List;

public class LibraryInnerExample {
    private String libraryName;
    private List<Book> books;

    // Constructor for Library
    public LibraryInnerExample(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }


    // Method to add a book to the library's collection
    public void addBook(String title, String author) {
        Book book = new Book(title, author); // Implicitly linked to this instance of Library
        books.add(book);
    }



    // Non-static inner class representing a Book
    public class Book {
        private String title;
        private String author;

        // Constructor for Book
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

    public static void main(String[] args) {
        // Creating a Library instance
        LibraryInnerExample cityLibrary = new LibraryInnerExample("City Library");

        // Adding books to the library
        cityLibrary.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        cityLibrary.addBook("Moby Dick", "Herman Melville");

        // Displaying all books in the library
        System.out.println("Library Books:");
        cityLibrary.books.forEach(book -> System.out.println(book));
    }
}
