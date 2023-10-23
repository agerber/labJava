package edu.uchicago.gerber.labjava.lec04._varargs;

import java.util.Arrays;

public class BookstoreDemo {

    public static void main(String[] args) {
        BookstoreDemo demo = new BookstoreDemo();

        // Creating books with title, author, and tags
        demo.createBook("The Great Adventure", "John Doe", "Adventure", "Fantasy");
        demo.createBook("History of Java", "Jane Smith", "Programming", "Java", "History");
        demo.createBook("Cosmic Journey", "Alice Johnson", "Space", "Mystery", "Sci-Fi");
        demo.createBook("No Tags Book", "Robert Brown");
    }

    public class Book {
        private String title;
        private String author;
        private String[] tags;

        public Book(String title, String author, String... tags) {
            this.title = title;
            this.author = author;
            this.tags = tags;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", tags=" + Arrays.toString(tags) +
                    '}';
        }
    }

    public void createBook(String title, String author, String... tags) {
        Book book = new Book(title, author, tags);
        System.out.println(book);
    }
}
