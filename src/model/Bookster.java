package model;

public class Bookster{
    private Book[] books = new Book[30];
    private User[] users = new User[20];
    private Company[] companies = new Company[10];
    private PickUpPoint[] pickUpPoints = new PickUpPoint[10];
    private Borrowing[] borrowings = new Borrowing[20];

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Company[] getCompanies() {
        return companies;
    }

    public void setCompanies(Company[] companies) {
        this.companies = companies;
    }

    public Borrowing[] getBorrows() {
        return borrowings;
    }

    public void setBorrows(Borrowing[] borrowings) {
        this.borrowings = borrowings;
    }

    public PickUpPoint[] getPickUpPoints() {
        return pickUpPoints;
    }

    public void setPickUpPoints(PickUpPoint[] pickUpPoints) {
        this.pickUpPoints = pickUpPoints;
    }
}
