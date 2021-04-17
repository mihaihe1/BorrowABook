package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;


public class Borrowing {
    private User user;
    private Book book;
    private final LocalDate startingDate;
    private final LocalDate endingDate;

    public Borrowing(User user, Book book){
        this.user = user;
        this.book = book;

        SimpleDateFormat formatter1= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.startingDate = LocalDate.now();
        this.endingDate = startingDate.plusDays(30);
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

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    @Override
    public String toString(){
        return user.getUserName() + " / " + book.getTitle() + " / " + startingDate + " / " + endingDate;
    }

}
