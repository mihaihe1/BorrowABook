package model;

public abstract class Book {
    private int id;
    private String title;
    private String author;
    private int pageNumber;
    private String genre;
    private int publicationYear;
    private double userRating;
    private int price;

    public Book(int i, String t, String a, int pN, String g, int pY, double uR, int p){
        this.id = i;
        this.title = t;
        this.author = a;
        this.pageNumber = pN;
        this.genre = g;
        this.publicationYear = pY;
        this.userRating = uR;
        this.price = p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
