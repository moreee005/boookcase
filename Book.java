package BookCase;

import java.util.ArrayList;
import java.util.List;

class Book {
    private String code;
    private String title;
    private String author;
    private String publisher;
    

    // Constructor
    public Book(String code, String title, String author, String publisher) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    

    public void displayDetails() {
        System.out.println("Code: " + code);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
       
        System.out.println();
    }
}

