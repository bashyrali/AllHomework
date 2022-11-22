package com.company.lesson.lesson45;

import java.util.ArrayList;
import java.util.List;

public class BooksCollection {
    private Book book;
    private List<Book> books = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public BooksCollection(){
        this.books.add(new Book("book1989","Bashyr"));
        this.books.add(new Book("history of bashyr","Bashyr"));
        this.books.add(new Book("bashyrland","Bashyr"));
        this.employees.add(new Employee("John"));
        this.employees.add(new Employee("Bob"));
        this.employees.add(new Employee("Stew"));
        employees.get(2).takeTheBook(books.get(2));
        this.book = books.get(0);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
