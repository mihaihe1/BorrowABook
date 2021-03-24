package model;

public abstract class Book extends Object {
    private int id;
    private String title;
    private String author;
    private int pageNumber;
    private String genre;
    private int publicationYear;
    private double userRating;
    private double price;

    public Book(int id, String title, String author, int pageNumber, String genre, int publicationYear, double userRating, double price){
        this.id = id;
        this.title = title;
        this.author = author;
        this.pageNumber = pageNumber;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.userRating = userRating;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return id + " / " + title + " / " + author + " / " + pageNumber + " / " + genre + " / " + publicationYear + " / " + userRating + " / " + price;
    }
}
