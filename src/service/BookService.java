package service;

import model.Book;
import model.Bookster;

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

}
