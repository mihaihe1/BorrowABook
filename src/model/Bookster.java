package model;

import java.util.ArrayList;
import java.util.List;

public class Bookster{
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Company> companies = new ArrayList<>();
    private List<PickUpPoint> pickUpPoints = new ArrayList<>();
    private List<Borrowing> borrowings = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Borrowing> getBorrows() {
        return borrowings;
    }

    public void setBorrows(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }

    public List<PickUpPoint> getPickUpPoints() {
        return pickUpPoints;
    }

    public void setPickUpPoints(List<PickUpPoint> pickUpPoints) {
        this.pickUpPoints = pickUpPoints;
    }
}
