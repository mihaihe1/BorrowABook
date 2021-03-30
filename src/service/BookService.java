package service;

import model.Book;
import model.Bookster;
import model.DigitalBook;
import model.User;

public class BookService {

    public void addBook(Bookster db, Book book){
        int nextAvailableIndex = getNumberOfBooks(db);
        db.getBooks()[nextAvailableIndex] = book;
    }

    public int getNumberOfBooks(Bookster db){
        int nrBooks = 0;
        for(Book b : db.getBooks()){
            if(b != null){
                nrBooks++;
            }
        }
        return nrBooks;
    }

    public void printBooksDetails(Bookster db){
        for(Book b : db.getBooks()){
            if(b != null)
                System.out.println(b);
        }
    }

    public void updateBookStock(Book book, int stock){
        book.setStock(stock);
    }

    public void searchBookByGenre(Bookster db, String genre){

        boolean ok = false;

        for(Book b : db.getBooks())
            if(b != null && b.getGenre() == genre){
                System.out.println(b);
                ok = true;
            }
        if(!ok)
            System.out.println("There are no books of that genre!");
    }

    public void rateBook(Bookster db, User user, String bookTitle, int rating){
        for(Book b : db.getBooks())
            if(b != null && b.getTitle() == bookTitle){
                double ratingActual = b.getUserRating();
                int nrRatings = b.getNrRatings();
                double newRating = ((ratingActual * nrRatings) + rating) / (nrRatings+1);
                b.setNrRatings(nrRatings+1);
                b.setUserRating(newRating);
            }
    }

    public void removeBook(Bookster db, String bookTitle){
        int i = 0;
        for(Book b : db.getBooks()) {
            if (b != null && b.getTitle() == bookTitle) {
                for (int j = i + 1; j < getNumberOfBooks(db); ++j)
                    db.getBooks()[j - 1] = db.getBooks()[j];
                db.getBooks()[getNumberOfBooks(db) - 1] = null;
                break;
            }

            i++;
        }

    }

}
