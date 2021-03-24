package model;

public class Bookster{
    private Book[] books = new Book[30];
    private User[] users = new User[20];
    private Company[] companies = new Company[10];
    private Borrow[] borrows = new Borrow[20];

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

    public Borrow[] getBorrows() {
        return borrows;
    }

    public void setBorrows(Borrow[] borrows) {
        this.borrows = borrows;
    }
}
