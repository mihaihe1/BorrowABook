package model;

public class User {
    private int id;
    private String name;
    private String email;
    private String address;
//    private Book[] bookList;

    public User(int id, String name, String email, String address){
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
//        this.bookList = bL;
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

//    public Book[] getBookList() {
//        return bookList;
//    }
//
//    public void setBookList(Book[] bookList) {
//        this.bookList = bookList;
//    }
}
