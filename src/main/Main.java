package main;
import model.*;
import service.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Bookster db = new Bookster();
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        Book Book1 = new PhysicalBook(1, "Crime and Punishment", "Dostoievski", 500, "mystery",1920,2,2,"Hard",true);
        //String det = scanner.nextLine();
        //String[] att = det.split("/");
        service.addBook(db, Book1);
        for (Book book : db.getBooks()){
            if(book != null && book instanceof PhysicalBook)
            {
                PhysicalBook bb = (PhysicalBook) book;
                System.out.println(bb.getCoverType());
            }
        }

//        User user1 = new User(1, "mihaihe", "mihai@gmail.com", "Str. PAO, nr. 242");
//        service.addUser(db, user1);
//        System.out.println(db.getUsers()[0].getName());
        service.printBooksDetails(db);

    }
}
