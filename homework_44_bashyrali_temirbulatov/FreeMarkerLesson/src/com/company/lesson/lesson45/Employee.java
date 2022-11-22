package com.company.lesson.lesson45;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private List<Book> bookHistory = new ArrayList<>();
    private Book availableBook;
    public Employee(String name){
        this.name = name;
    }
    public void takeTheBook(Book book){
        this.availableBook = book;
        bookHistory.add(book);
        book.setAvailable(false);
        book.setOwner(this);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookHistory() {
        return bookHistory;
    }

    public void setBookHistory(List<Book> bookHistory) {
        this.bookHistory = bookHistory;
    }

    public Book getAvailableBook() {
        return availableBook;
    }

    public void setAvailableBook(Book availableBook) {
        this.availableBook = availableBook;
    }
}
