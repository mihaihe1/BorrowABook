package model;

public abstract class Book implements Comparable<Book>{
    private String title;
    private String author;
    private int pageNumber;
    private String genre;
    private int publicationYear;
    private double userRating;
    private int nrRatings;
    private int stock;

    public Book(String title, String author, int pageNumber, String genre, int publicationYear, int stock){
        this.title = title;
        this.author = author;
        this.pageNumber = pageNumber;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.stock = stock;
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

    public int getNrRatings() {
        return nrRatings;
    }

    public void setNrRatings(int nrRatings) {
        this.nrRatings = nrRatings;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString(){
        return title + " / " + author + " / " + pageNumber + " / " + genre + " / " + publicationYear + " / " + userRating + " / " + stock;
    }

    @Override
    public int compareTo(Book b){
        return Integer.compare(this.getPublicationYear(), b.getPublicationYear());

    }
}
