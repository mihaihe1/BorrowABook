package service;
import model.*;

public class Service {
    public void addUser(Bookster db, User user){
        int nextAvailableIndex = getNumberOfUsers(db);
        db.getUsers()[nextAvailableIndex] = user;
    }

    public void addBook(Bookster db, Book book){
        int nextAvailableIndex = getNumberOfBooks(db);
        db.getBooks()[nextAvailableIndex] = book;
    }

    public void printBooksDetails(Bookster db){
        for(Book b : db.getBooks()){
            if(b != null)
                System.out.println(b);
        }
    }

    public int getNumberOfUsers(Bookster db){
        int nrUsers = 0;
        for(User u : db.getUsers()){
            if(u != null){
                nrUsers++;
            }
        }
        return nrUsers;
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
