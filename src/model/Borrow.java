package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Borrow {
    private User user;
    private Book book;
    private final Date startingDate;
    private final Date endingDate;

    public Borrow(User user, Book book){
        this.user = user;
        this.book = book;

        SimpleDateFormat formatter1= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.startingDate = new Date(System.currentTimeMillis());

        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 30);
        Date currentDatePlusMonth = c.getTime();

        this.endingDate = currentDatePlusMonth;
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

    public Date getEndingDate() {
        return endingDate;
    }

    @Override
    public String toString(){
        return user.getUserName() + " / " + book.getTitle() + " / " + startingDate + " / " + endingDate;
    }

}
