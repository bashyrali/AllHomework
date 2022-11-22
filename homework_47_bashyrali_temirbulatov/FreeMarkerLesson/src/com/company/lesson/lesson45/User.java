package com.company.lesson.lesson45;

import com.mysql.cj.x.protobuf.MysqlxExpr;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    public String email;
    public String password;
    private List<Book> bookHistory = new ArrayList<>();
    private List<Book> availableBook = new ArrayList<>();



    public User(int id,String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public void takeTheBook(Book book){
        this.availableBook.add(book);
        this.bookHistory.add(book);
        book.setAvailable(false);
        book.setOwner(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBookHistory() {
        return bookHistory;
    }

    public void setBookHistory(List<Book> bookHistory) {
        this.bookHistory = bookHistory;
    }

    public List<Book> getAvailableBook() {
        return availableBook;
    }

    public void setAvailableBook(List<Book> availableBook) {
        this.availableBook = availableBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
