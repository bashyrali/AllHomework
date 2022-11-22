package com.company.lesson.lesson45;

public class ActiveUser {
    User user;
    Books books;

    public ActiveUser(User user, Books books) {
        this.user = user;
        this.books = books;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public void takeBook(Book book,User user){
        user.getAvailableBook().add(book);
        user.getBookHistory().add(book);
        for (int i = 0; i < books.getBooks().size(); i++) {
            if (books.getBooks().get(i).equals(book)){
                books.getBooks().get(i).setOwner(user);
                books.getBooks().get(i).setAvailable(false);
            }
        }


    }
}
