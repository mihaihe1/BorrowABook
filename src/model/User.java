package model;

public class User {
    private int id;
    private String name;
    private String email;
    private String address;
    private Book[] bookList;

    public User(int i, String n, String e, String a, Book[] bL){
        this.id = i;
        this.name = n;
        this.email = e;
        this.address = a;
        this.bookList = bL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Book[] getBookList() {
        return bookList;
    }

    public void setBookList(Book[] bookList) {
        this.bookList = bookList;
    }
}
