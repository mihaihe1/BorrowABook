/*
    Obiecte:
        -Book
            -PhysicalBook
            -DigitalBook
        -Bookster
        -Borrow
        -User
            -Person
            -Company
        -PickUpPoint
        -Subscription
        -Service
        -BookService
        -UserService

    Actiuni:
        - adaugare carte
        - adaugare pickuppoint
        - adaugare user
        - adaugare imprumut
        - adaugare persoana la companie
        - adaugare rating carte
        - afisare carti
        - afisare useri
        - afisare imprumuturi
        - afisare firma careia o sa ii expire cel mai repede abonamentul
        - calculare nr maxim de carti pe care o persoana le poate imprumuta
        - calculare nr de carti imprumutate de o persoana
        - actualizare stoc carte
        - actualizare adresa pickuppoint
        - cautare carti dupa gen
*/
package main;
import model.*;
import service.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Bookster db = new Bookster();
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);


        Subscription bronzeSubscription = new Subscription("bronze");
        Subscription silverSubscription = new Subscription("silver");
        Subscription goldSubscription = new Subscription("gold");
        PickUpPoint pickUpUnirii = new PickUpPoint("Bucharest", "Str. Unirii", true);
        service.addPickUpPoint(db, pickUpUnirii);

        User user1 = new Person("mihai", "1234", "mihai@gmail.com", "Mihai", "Hernest", "Str. Unibuc", "0734567890");
        service.addUser(db, user1);

        User userGoogle = new Company("google_bookster", "12345", "google@gmail.com", "Google","Str. Google", new Person[100], bronzeSubscription);
        User userTesla = new Company("tesla_books", "5555", "tesla@gmail.com", "Tesla", "Str. Tesla", new Person[50], goldSubscription);
        service.addUser(db, userTesla);
        service.addUser(db, userGoogle);
        service.addPersonToCompany((Person)user1, (Company)userGoogle);
        service.printUsersDetails(db);

        Book book1 = new PhysicalBook("Crime and Punishment", "Dostoevsky", 500, "mystery",1866,2,"Hard",true);
        Book book2 = new DigitalBook("The Metamorphosis", "Kafka", 100, "fiction", 1915, 10, ".pdf", true);
        service.addBook(db, book1);
        service.addBook(db, book2);
        service.printBooksDetails(db);
        service.updateBookStock(book1, 5);
        service.printBooksDetails(db);
        Borrow borrow1 = new Borrow(user1, book1);
        service.addBorrow(db, borrow1);

//        service.addBorrow(db, borrow1);
        service.printBorrowDetails(db);
        service.printBooksDetails(db);

        service.updatePickUpPointAddress(pickUpUnirii, "Str. Unirii2");
        service.printPickUpPoints(db);

        service.searchBookByGenre(db, "mystery");

        service.rateBook(db, user1, "Crime and Punishment", 5);
        service.rateBook(db, userGoogle, "Crime and Punishment", 4);
        service.printBooksDetails(db);
        service.printFirstCompanyWithExpiredSubscription(db);

        // ---------------------MENU-----------------------
        /*while(true){
            System.out.println("Please type one of the following commands: add, view or exit");
            String line = scanner.nextLine();
            switch (line){
                case "add":
                    System.out.println("Please specify the title");
                    String title = scanner.nextLine();
                    System.out.println("Please specify the author");
                    String author = scanner.nextLine();
                    System.out.println("Please specify the nr of pages");
                    String nrPagString = scanner.nextLine();
                    int nrPag = Integer.parseInt(nrPagString);
                    System.out.println("Please specify the genre");
                    String genre = scanner.nextLine();
                    System.out.println("Please specify the year of publication");
                    String yearString = scanner.nextLine();
                    int year = Integer.parseInt(yearString);
                    System.out.println("Please specify the nr of books in stock");
                    String stockString = scanner.nextLine();
                    int stock = Integer.parseInt(stockString);

                    System.out.println("Please specify the type: digital / physical");
                    String type = scanner.nextLine();
                    switch (type){
                        case "digital":
                            System.out.println("Please specify the format");
                            String format = scanner.nextLine();
                            System.out.println("Please specify if the book has a free trial");
                            String freeTrialString = scanner.nextLine();
                            boolean freeTrial = Boolean.parseBoolean(freeTrialString);
                            if(freeTrial == true) {
                                System.out.println("Please specify the free trial length");
                                String lengthString = scanner.nextLine();
                                int length = Integer.parseInt(lengthString);
                                Book book = new DigitalBook(title, author, nrPag, genre, year, stock, format, freeTrial, length);
                                service.addBook(db, book);
                            }
                            else{
                                Book book = new DigitalBook(title, author, nrPag, genre, year, stock, format, freeTrial);
                                service.addBook(db, book);
                            }
                            break;

                        case "physical":
                            System.out.println("Please specify the cover type");
                            String cover = scanner.nextLine();
                            System.out.println("Please specify if the book is new");
                            String isNewString = scanner.nextLine();
                            boolean isNew = Boolean.parseBoolean(isNewString);
                            Book book = new PhysicalBook(title, author, nrPag, genre, year, stock, cover, isNew);
                            service.addBook(db, book);
                            break;
                    }
                break;

                case "view":
                    service.printBooksDetails(db);
                    break;

                case "exit" :
                    System.out.println("Bye bye!");
                    System.exit(0);
                    break;

                default : System.out.println("This command doesn't exist.");


            }
        }*/

        //String det = scanner.nextLine();
        //String[] att = det.split("/");
//        service.addBook(db, Book1);

//        User user1 = new User(1, "mihaihe", "mihai@gmail.com", "Str. PAO, nr. 242");
//        service.addUser(db, user1);
//        System.out.println(db.getUsers()[0].getName());

    }
}
