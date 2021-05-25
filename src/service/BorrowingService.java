package service;

import model.*;
import repository.BorrowingRepository;

public class BorrowingService {

    private BorrowingRepository borrowingRepository;

    public BorrowingService(){
        this.borrowingRepository = new BorrowingRepository();
    }

    public void updateBook(int id_user, int id_book, int newBookId){ borrowingRepository.updateBook(id_user, id_book, newBookId); }

    public void addBorrowing(Borrowing borrowing){
        borrowingRepository.addBorrowing(borrowing);
    }

    public void removeBorrowing(int id_user, int id_book){
        borrowingRepository.removeBorrowing(id_user, id_book);
    }

    public void printBorrowingDetails(){ borrowingRepository.printBorrowingsDetails(); }

}
