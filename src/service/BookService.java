package service;

import model.*;
import repository.DigitalbookRepository;
import repository.PhysicalbookRepository;

public class BookService {

    private PhysicalbookRepository physicalbookRepository;
    private DigitalbookRepository digitalbookRepository;

    public BookService(){
        this.physicalbookRepository = new PhysicalbookRepository();
        this.digitalbookRepository = new DigitalbookRepository();
    }

    public void addPhysicalBook(PhysicalBook book){
        physicalbookRepository.addPhysicalBook(book);
    }

    public void addDigitalBook(DigitalBook book){
        digitalbookRepository.addDigitalBook(book);
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
            if(b != null && b.getGenre().equals(genre)){
                System.out.println(b);
                ok = true;
            }
        if(!ok)
            System.out.println("There are no books of that genre!");
    }

    public void ratePhysicalBook(User user, PhysicalBook book, int rating){
        physicalbookRepository.ratePhysicalBook(user, book, rating);
    }

    public void removeDigitalBook(int id){
        digitalbookRepository.deleteDigitalBook(id);
    }

    public void removePhysicalBook(int id){
        physicalbookRepository.deletePhysicalBook(id);
    }


    public Book searchBook(Bookster db, String bookTitle) {
        for(Book b: db.getBooks())
            if (b != null && b.getTitle().equals(bookTitle))
                return b;
        return null;
    }

}
