package model;

import java.util.Date;

public class Borrow {
    private User user;
    private Book book;
    private Date startingDate;
    private Date endingDate;

    public Borrow(User user, Book book, Date startingDate, Date endingDate){
        this.user = user;
        this.book = book;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }
}
