package service;
import model.*;

public class Service {

    private final BookService bookService = new BookService();
    private final UserService userService = new UserService();
    private final PickUpPointService pickUpPointService = new PickUpPointService();
    private final BorrowingService borrowingService = new BorrowingService();
    private final LoggingService loggingService = new LoggingService();

    public void addUser(Bookster db, User user){ userService.addUser(db, user); loggingService.logEvent("add user");}

    public void removeUser(Bookster db, String username){ userService.removeUser(db, username); loggingService.logEvent("remove user");}

    public Person searchPerson(Bookster db, String username){ Person p = userService.searchPerson(db, username); loggingService.logEvent("search person"); return p;}

    public Company searchCompany(Bookster db, String username){ Company c = userService.searchCompany(db, username); loggingService.logEvent("search company"); return c;}

    public void addPersonToCompany(Person person, Company company){
        userService.addPersonToCompany(person, company);
        loggingService.logEvent("add person to company");
    }

    public void printUsersDetails(Bookster db){
        userService.printUsersDetails(db);
        loggingService.logEvent("print users");
    }

    public void printFirstCompanyWithExpiredSubscription(Bookster db){
        userService.printFirstCompanyWithExpiredSubscription(db);
        loggingService.logEvent("print first company with expired sub");
    }



    public void addBook(Bookster db, Book book){
        bookService.addBook(db, book);
        loggingService.logEvent("add book");
    }

    public void removeBook(Bookster db, String bookTitle){
        bookService.removeBook(db, bookTitle);
        loggingService.logEvent("remove book");
    }

    public void printBooksDetails(Bookster db){
        bookService.printBooksDetails(db);
        loggingService.logEvent("print books");
    }

    public void searchBookByGenre(Bookster db, String genre){
        bookService.searchBookByGenre(db, genre);
        loggingService.logEvent("search books by user");
    }

    public void updateBookStock(Book book, int stock) {
        bookService.updateBookStock(book, stock);
        loggingService.logEvent("update book stock");
    }

    public void rateBook(Bookster db, User user, String bookTitle, int rating){
        bookService.rateBook(db, user, bookTitle, rating);
        loggingService.logEvent("rate book");
    }



    public void addPickUpPoint(Bookster db, PickUpPoint pickUpPoint){
        pickUpPointService.addPickUpPoint(db, pickUpPoint);
        loggingService.logEvent("add pick up point");
    }

    public void printPickUpPoints(Bookster db){
        pickUpPointService.printPickUpPoints(db);
        loggingService.logEvent("print pick up points");
    }

    public void updatePickUpPointAddress(PickUpPoint pickUpPoint, String address){
        pickUpPoint.setAddress(address);
        loggingService.logEvent("update pick up point");
    }


    public void addBorrowing(Bookster db, Borrowing borrowing){
        borrowingService.addBorrowing(db, borrowing);
        loggingService.logEvent("add borrowing");
    }

    public void printBorrowingDetails(Bookster db){
        borrowingService.printBorrowingDetails(db);
        loggingService.logEvent("print borrowings");
    }

}
