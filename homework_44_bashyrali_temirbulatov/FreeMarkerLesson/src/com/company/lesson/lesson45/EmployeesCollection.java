package com.company.lesson.lesson45;

import java.util.List;

public class EmployeesCollection {
    BooksCollection booksCollection = new BooksCollection();
    private List<Employee> employees = booksCollection.getEmployees();

    public BooksCollection getBooksCollection() {
        return booksCollection;
    }

    public void setBooksCollection(BooksCollection booksCollection) {
        this.booksCollection = booksCollection;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
