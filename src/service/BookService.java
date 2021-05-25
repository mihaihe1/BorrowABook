package service;

import model.*;
import repository.DigitalbookRepository;
import repository.PhysicalbookRepository;

import java.util.Optional;

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

    public void printBooksDetails(){
        digitalbookRepository.printBooksDetails();
    }

    public void updateBookStock(Book book, int stock){
        book.setStock(stock);
    }

    public void searchBookByGenre(String genre){
        physicalbookRepository.searchBooksByGenre(genre);
    }

    public void ratePhysicalBook(User user, PhysicalBook book, int rating){ physicalbookRepository.ratePhysicalBook(user, book, rating); }

    public void rateDigitalBook(User user, DigitalBook book, int rating){ digitalbookRepository.rateDigitalBook(user, book, rating); }

    public void removeDigitalBook(int id){
        digitalbookRepository.deleteDigitalBook(id);
    }

    public void removePhysicalBook(int id){
        physicalbookRepository.deletePhysicalBook(id);
    }

    public Optional<PhysicalBook> getPhysicalBookById(int id){ return physicalbookRepository.getPhysicalBookById(id); }

    public Optional<DigitalBook> getDigitalBookById(int id){ return digitalbookRepository.getDigitalBookById(id); }
}
