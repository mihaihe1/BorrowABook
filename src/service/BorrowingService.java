package service;

import model.*;
import repository.BorrowingRepository;

public class BorrowingService {

    private BorrowingRepository borrowingRepository;

    public BorrowingService(){
        this.borrowingRepository = new BorrowingRepository();
    }

    public void updateBook(int id_user, int id_book, int newBookId){
        borrowingRepository.updateBook(id_user, id_book, newBookId);
    }

    public void addBorrowing(Borrowing borrowing){
        borrowingRepository.addBorrowing(borrowing);
    }

    public void removeBorrowing(int id_user, int id_book){
        borrowingRepository.removeBorrowing(id_user, id_book);
    }

    public int getNumberOfBorrowedBooksByUser(Bookster db, User user){
        int nrBooks = 0;
        String username = user.getUserName();
        for(Borrowing b : db.getBorrowings())
            if (b != null && b.getUser().getUserName().equals(username))
                nrBooks++;

        return nrBooks;
    }

    public void printBorrowingDetails(Bookster db){
        for(Borrowing b : db.getBorrowings()){
            if(b != null)
                System.out.println(b);
        }
    }

//    public int getMaxToBorrow(Bookster db, User user){
//        for(User u : db.getUsers())
//            if(u instanceof Company){
//                Person[] employeeList = ((Company) u).getEmployees();
//                for(Person p : employeeList)
//                    if(p != null && p.getUserName().equals(user.getUserName()))
//                        return ((Company) u).getSubscription().getMaxNumberToBorrow();
//            }
//
//        return 0;
//    }
}
