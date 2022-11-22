package com.company.lesson.lesson45;

public class Book {
    private String name;
    private String author;
    private final String description;
    private boolean available = true;
    private Employee owner =  null;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.description = "Hello it's just a book!";

    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
