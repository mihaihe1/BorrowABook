package service;
import model.*;

public class Service {

    private final BookService bookService = new BookService();
    private final UserService userService = new UserService();
    private final PickUpPointService pickUpPointService = new PickUpPointService();
    private final BorrowingService borrowingService = new BorrowingService();

    public void addUser(Bookster db, User user){ userService.addUser(db, user); }

    public void removeUser(Bookster db, String username){ userService.removeUser(db, username);}

    public void addPersonToCompany(Person person, Company company){ userService.addPersonToCompany(person, company);}

    public void printUsersDetails(Bookster db){ userService.printUsersDetails(db);}

    public void printFirstCompanyWithExpiredSubscription(Bookster db){ userService.printFirstCompanyWithExpiredSubscription(db);}



    public void addBook(Bookster db, Book book){ bookService.addBook(db, book);}

    public void removeBook(Bookster db, String bookTitle){ bookService.removeBook(db, bookTitle);}

    public void printBooksDetails(Bookster db){ bookService.printBooksDetails(db);}

    public void searchBookByGenre(Bookster db, String genre){ bookService.searchBookByGenre(db, genre);}

    public void updateBookStock(Book book, int stock) { bookService.updateBookStock(book, stock);}

    public void rateBook(Bookster db, User user, String bookTitle, int rating){ bookService.rateBook(db, user, bookTitle, rating);}



    public void addPickUpPoint(Bookster db, PickUpPoint pickUpPoint){ pickUpPointService.addPickUpPoint(db, pickUpPoint);}

    public void printPickUpPoints(Bookster db){ pickUpPointService.printPickUpPoints(db);}

    public void updatePickUpPointAddress(PickUpPoint pickUpPoint, String address){ pickUpPoint.setAddress(address);}


    public void addBorrowing(Bookster db, Borrowing borrowing){ borrowingService.addBorrowing(db, borrowing);}

    public void printBorrowingDetails(Bookster db){ borrowingService.printBorrowingDetails(db);}



}
