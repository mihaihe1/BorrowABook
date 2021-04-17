package service;

import model.*;

public class BorrowingService {
    public void addBorrowing(Bookster db, Borrowing borrowing){
//        boolean inStock = false;
        String borrowedBookTitle = borrowing.getBook().getTitle();
        int maxToBorrow = getMaxToBorrow(db, borrowing.getUser());
//        System.out.println(maxToBorrow);
        int nrBooksBorrowed = getNumberOfBorrowedBooksByUser(db, borrowing.getUser());

        if(borrowing.getUser() instanceof Company)
            System.out.println("You can't borrow books from a company's account");
        else
        if(nrBooksBorrowed == maxToBorrow)
            System.out.println("User: " + borrowing.getUser().getUserName() + " reached the limit of books that he can borrow: " + maxToBorrow);
        else {

            for (Book b : db.getBooks()) {
                if (b != null && b.getTitle().equals(borrowedBookTitle)) {
                    int stock = b.getStock();

                    if (stock > 0) {
//                        inStock = true;
                        updateBookStock(b, stock - 1);
                        int nextAvailableIndex = getNumberOfBorrowings(db);
                        db.getBorrows()[nextAvailableIndex] = borrowing;
                    } else {
                        System.out.println("This book is out of stock!");
                    }
                    break;
                }
            }
            System.out.println("User: " + borrowing.getUser().getUserName() + " can borrow " + (maxToBorrow - nrBooksBorrowed - 1) + " more books!");
        }
    }

    public int getNumberOfBorrowedBooksByUser(Bookster db, User user){
        int nrBooks = 0;
        String username = user.getUserName();
        for(Borrowing b : db.getBorrows())
            if (b != null && b.getUser().getUserName().equals(username))
                nrBooks++;

        return nrBooks;
    }

    public int getNumberOfBorrowings(Bookster db){
        int nrP = 0;
        for(Borrowing p : db.getBorrows()){
            if(p != null){
                nrP++;
            }
        }
        return nrP;
    }

    public void printBorrowingDetails(Bookster db){
        for(Borrowing b : db.getBorrows()){
            if(b != null)
                System.out.println(b);
        }
    }

    public int getMaxToBorrow(Bookster db, User user){
        for(User u : db.getUsers())
            if(u instanceof Company){
                Person[] employeeList = ((Company) u).getEmployees();
                for(Person p : employeeList)
                    if(p != null && p.getUserName().equals(user.getUserName()))
                        return ((Company) u).getSubscription().getMaxNumberToBorrow();
            }

        return 0;
    }

    public void updateBookStock(Book book, int stock){
        book.setStock(stock);
    }
}