package service;
import model.*;

public class Service {
    public void addBook(DataBase db, Book book){
        db.getBooks()[0] = book;
    }
}
