package service;
import model.*;

public class Service {

    private final BookService bookService = new BookService();
    private final UserService userService = new UserService();

    public void addUser(Bookster db, User user){
        userService.addUser(db, user);
    }

    public void addPersonToCompany(Person person, Company company){
        userService.addPersonToCompany(person, company);
    }

    public void printUsersDetails(Bookster db){
        userService.printUsersDetails(db);
    }

    public void addBook(Bookster db, Book book){
        bookService.addBook(db, book);
    }

    public void printBooksDetails(Bookster db){
        bookService.printBooksDetails(db);
    }

    public void searchBookByGenre(Bookster db, String genre){
        bookService.searchBookByGenre(db, genre);
    }

    public void updateBookStock(Book book, int stock) {
        bookService.updateBookStock(book, stock);
    }

    public void rateBook(Bookster db, User user, String bookTitle, int rating){
        bookService.rateBook(db, user, bookTitle, rating);
    }


    // -------------------START PICKUP

    public void addPickUpPoint(Bookster db, PickUpPoint pickUpPoint){
        int nextAvailableIndex = getNumberOfPickUpPoints(db);
        db.getPickUpPoints()[nextAvailableIndex] = pickUpPoint;
    }

    public int getNumberOfPickUpPoints(Bookster db){
        int nrP = 0;
        for(PickUpPoint p : db.getPickUpPoints()){
            if(p != null){
                nrP++;
            }
        }
        return nrP;
    }

    public void printPickUpPoints(Bookster db){
        for(PickUpPoint p : db.getPickUpPoints()){
            if(p != null)
                System.out.println(p);
        }
    }

    public void updatePickUpPointAddress(PickUpPoint pickUpPoint, String address){
        pickUpPoint.setAddress(address);
    }

    // ---------------------- END PICKUP

    // --------------------START BORROW

    public void addBorrow(Bookster db, Borrow borrow){
        boolean inStock = false;
        String borrowedBookTitle = borrow.getBook().getTitle();
        int maxToBorrow = userService.getMaxToBorrow(db, borrow.getUser());
        System.out.println(maxToBorrow);
        int nrBooksBorrowed = getNumberOfBorrowedBooksByUser(db, borrow.getUser());

        if(borrow.getUser() instanceof Company)
            System.out.println("You can't borrow books from a company's account");
        else
        if(nrBooksBorrowed == maxToBorrow)
            System.out.println("You have reached the limit of books that you can borrow: " + maxToBorrow);
        else {

            for (Book b : db.getBooks()) {
                if (b != null && b.getTitle() == borrowedBookTitle) {
                    int stock = b.getStock();

                    if (stock > 0) {
                        inStock = true;
                        updateBookStock(b, stock - 1);
                        int nextAvailableIndex = getNumberOfBorrows(db);
                        db.getBorrows()[nextAvailableIndex] = borrow;
                    } else {
                        System.out.println("This book is out of stock!");
                    }
                    break;
                }
            }
        }
    }

    public int getNumberOfBorrowedBooksByUser(Bookster db, User user){
        int nrBooks = 0;
        String username = user.getUserName();
        for(Borrow b : db.getBorrows())
            if (b != null && b.getUser().getUserName() == username)
                nrBooks++;

        return nrBooks;
    }

    public int getNumberOfBorrows(Bookster db){
        int nrP = 0;
        for(Borrow p : db.getBorrows()){
            if(p != null){
                nrP++;
            }
        }
        return nrP;
    }

    public void printBorrowDetails(Bookster db){
        for(Borrow b : db.getBorrows()){
            if(b != null)
                System.out.println(b);
        }
    }


    // ----------------------END BORROW

}
