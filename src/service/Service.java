package service;
import model.*;

import java.util.Optional;

public class Service {

    private final BookService bookService = new BookService();
    private final UserService userService = new UserService();
    private final PickUpPointService pickUpPointService = new PickUpPointService();
    private final BorrowingService borrowingService = new BorrowingService();
    private final LoggingService loggingService = new LoggingService();

    public void addPerson(Person person){
        userService.addPerson(person);
        loggingService.logEvent("add person");
    }

    public void addCompany(Company company){
        userService.addCompany(company);
        loggingService.logEvent("add company");
    }

    public void removePerson(String username){
        userService.removePerson(username);
        loggingService.logEvent("remove person");
    }

    public void removeCompany(String username){
        userService.removeCompany(username);
        loggingService.logEvent("remove company");
    }

    public Optional<Company> getCompanyById(int id){
        loggingService.logEvent("get company by id");
        return userService.getCompanyById(id);
    }

    public void updateCompanyLocation(int id, String location){
        userService.updateCompanyLocation(id, location);
        loggingService.logEvent("update company location");
    }


    public void addPersonToCompany(String username,int id){
        userService.addPersonToCompany(username, id);
        loggingService.logEvent("add person to company");
    }

    public void printUsersDetails(){
        userService.printUsersDetails();
        loggingService.logEvent("print users");
    }


    public void addPhysicalBook(PhysicalBook book){
        bookService.addPhysicalBook(book);
        loggingService.logEvent("add book");
    }

    public void addDigitalBook(DigitalBook book){
        bookService.addDigitalBook(book);
        loggingService.logEvent("add book");
    }

    public void removePhysicalBook(int id){
        bookService.removePhysicalBook(id);
        loggingService.logEvent("remove physical book");
    }

    public void removeDigitalBook(int id){
        bookService.removeDigitalBook(id);
        loggingService.logEvent("remove digital book");
    }

    public void removePickUpPoint(int id){
        pickUpPointService.removePickUpPoint(id);
        loggingService.logEvent("remove pickuppoint");
    }

    public void printBooksDetails(){
        bookService.printBooksDetails();
        loggingService.logEvent("print books");
    }

    public void searchBookByGenre(String genre){
        bookService.searchBookByGenre(genre);
        loggingService.logEvent("search book by genre");
    }

    public void updateBookStock(Book book, int stock) {
        bookService.updateBookStock(book, stock);
        loggingService.logEvent("update book stock");
    }

    public void ratePhysicalBook(User user, PhysicalBook book, int rating){
        bookService.ratePhysicalBook(user, book, rating);
        loggingService.logEvent("rate physical book");
    }

    public void rateDigitalBook(User user, DigitalBook book, int rating){
        bookService.rateDigitalBook(user, book, rating);
        loggingService.logEvent("rate digital book");
    }

    public Optional<PhysicalBook> getPhysicalBookById(int id){
        loggingService.logEvent("get physical book");
        return bookService.getPhysicalBookById(id);
    }

    public Optional<DigitalBook> getDigitalBookById(int id){
        loggingService.logEvent("get digital book");
        return bookService.getDigitalBookById(id);
    }


    public void addPickUpPoint(PickUpPoint pickUpPoint){
        pickUpPointService.addPickUpPoint(pickUpPoint);
        loggingService.logEvent("add pick up point");
    }

    public void printPickUpPoints(){
        pickUpPointService.printPickUpPoints();
        loggingService.logEvent("print pick up points");
    }

    public void updatePickUpPointAddress(int id, String address){
        pickUpPointService.updatePickUpPointAddress(id, address);
        loggingService.logEvent("update pick up point");
    }

    public Optional<PickUpPoint> getPickupPointById(int id){
        loggingService.logEvent("get pick up point");
        return pickUpPointService.getPickupPointById(id);
    }

    public void addBorrowing(Borrowing borrowing){
        borrowingService.addBorrowing(borrowing);
        loggingService.logEvent("add borrowing");
    }

    public void removeBorrowing(int id_user, int id_book){
        borrowingService.removeBorrowing(id_user, id_book);
        loggingService.logEvent("remove borrowing");
    }


    public void updateBook(int id_user, int id_book, int newBookId){
        borrowingService.updateBook(id_user, id_book, newBookId);
        loggingService.logEvent("update book in borrowing");
    }

    public void printBorrowingDetails(){
        borrowingService.printBorrowingDetails();
        loggingService.logEvent("print borrowings");
    }

}
