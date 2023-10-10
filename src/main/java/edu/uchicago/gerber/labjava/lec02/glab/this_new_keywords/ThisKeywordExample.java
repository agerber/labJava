package edu.uchicago.gerber.labjava.lec02.glab.this_new_keywords;

public class ThisKeywordExample {

    public static void main(String[] args) {


        //the new keyword returns the memeory address of the object on the heap


        Author tolkien = new Author("J.R.R. Tolkien")
                .setNationality("British");

        Book lotr = new Book("The Lord of the Rings", tolkien)
                .setPages(1200)
                .setGenre("Fantasy");

        System.out.println(lotr);
        System.out.println(lotr.getAuthorDetails());
    }
}

class Author {
    private String name;
    private String nationality;

    public Author(String name) {
        this.name = name;
    }

    public Author setNationality(String nationality) {
        this.nationality = nationality;
        return this;  // method chaining using 'this'
    }

    @Override
    public String toString() {
        return name + " (" + nationality + ")";
    }
}

class Book {
    private String title;
    private Author author;
    private int pages;
    private String genre;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;  // method chaining using 'this'
    }

    public Book setGenre(String genre) {
        this.genre = genre;
        return this;  // method chaining using 'this'
    }

    public String getAuthorDetails() {
        return "Author of '" + this.title + "' is: " + this.author;  // using 'this' for clarity
    }

    @Override
    public String toString() {
        return "Book[title=" + title + ", author=" + author + ", pages=" + pages + ", genre=" + genre + "]";
    }
}
