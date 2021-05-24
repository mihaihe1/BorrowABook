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
        - stergere carte
        - stergere user
*/
package main;
import model.*;
import repository.PickuppointRepository;
import service.*;
import service.RWServices.*;

import java.util.*;

public class Main {
    public static void main(String[] args){

        Bookster db = new Bookster();
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
//        RWPerson rwPerson = RWPerson.getInstance();
//        rwPerson.read(db, service);
//        RWPhysicalBook rwPhysicalBook = RWPhysicalBook.getInstance();
//        rwPhysicalBook.read(db, service);
//        RWDigitalBook rwDigitalBook = RWDigitalBook.getInstance();
//        rwDigitalBook.read(db, service);
//        RWCompany rwCompany = RWCompany.getInstance();
//        rwCompany.read(db, service);
//        RWPickUpPoint rwPickUpPoint = RWPickUpPoint.getInstance();
//        rwPickUpPoint.read(db, service);
//        RWBorrowing rwBorrowing = RWBorrowing.getInstance();
//        rwBorrowing.read(db, service);

//        service.addPersonToCompany((Person) user2, (Company) userTesla);


//        System.out.println("Inainte si dupa actualizare stoc");
//        service.printBooksDetails(db);
//        service.updateBookStock(book1, 5);
//        service.printBooksDetails(db);
//        System.out.println();
//
        User user1 = new Person("mihai_test", "1234", "mihai@gmail.com", "Mihai", "Hernest", "Str. Unibuc", "0734567890");
        PhysicalBook book1 = new PhysicalBook("Test Rating", "Dostoevsky", 500, "mystery",1866,2,"Hard",true);
        DigitalBook book2 = new DigitalBook("Test Rating", "Dostoevsky", 500, "mystery",1866,2,".pdf",true);
        Company userGoogle = new Company("google_bookster", "12345", "google@gmail.com", "Google","Str. Google", new Person[100], db.getSubscriptions().get(0));
//        service.addPhysicalBook(book1);
//        service.addDigitalBook(book2);
//        service.addUser(db, user1);
//        service.addUser(db, userGoogle);
        service.addCompany(userGoogle);
//        service.addPersonToCompany((Person)user1, (Company)userGoogle);
        Person user2 = new Person("mihai_test_comp", "1234", "mihai@gmail.com", "Mihai", "Hernest", "Str. Unibuc", "0734567890");
        service.addPerson(user2);
        Borrowing borrowing1 = new Borrowing(user2, book1);
//        service.addBorrowing(db, borrowing1);
//        PickUpPoint pickUpPoint = new PickUpPoint("Bucharest", "Str. Unirii", true);
//        service.addPickUpPoint(pickUpPoint);
//        service.removeDigitalBook(3);
//        service.removePhysicalBook(5);
//        service.removePerson("mihai_test");
        service.removePickUpPoint(2);
        service.updatePickUpPointAddress(4, "Str. Test");
//        service.removeBorrowing(1, 2);
        service.ratePhysicalBook(user2, book1, 5);
        ////        Borrowing borrowing2 = new Borrowing(user1, book2);
//        Borrowing borrowing3 = new Borrowing(user2, book2);
//        Borrowing borrowing4 = new Borrowing(userGoogle, book2);
//        System.out.println("Borrow");
////        service.addBorrowing(db, borrowing1);
////        service.addBorrowing(db, borrowing2);
//        service.addBorrowing(db, borrowing3);
//        service.addBorrowing(db, borrowing4);
//        System.out.println("Afisare imprumuturi si modificarile din stoc");
//        service.printBorrowingDetails(db);
//        service.printBooksDetails(db);
//        System.out.println();
//
//        System.out.println("Actualizare adresa pickup");
//        service.updatePickUpPointAddress(pickUpUnirii, "Str. Unirii2");
//        service.printPickUpPoints(db);
//        System.out.println();
//
//        System.out.println("Afisare carti dintr-un anumit gen");
//        service.searchBookByGenre(db, "mystery");
//        System.out.println();
//
//        System.out.println("Afisare carte inainte si dupa ce userul acorda rating");
//        service.printBooksDetails(db);
////        service.rateBook(db, user1, "Crime and Punishment", 5);
//        service.rateBook(db, user2, "Crime and Punishment", 4);
//        service.printBooksDetails(db);
//        System.out.println();
//
//        System.out.println("Afisarea companiei careia ii expira cel mai repede abonamentul");
//        service.printFirstCompanyWithExpiredSubscription(db);
//        System.out.println();
//
//        System.out.println("Stergere carte");
//        service.printBooksDetails(db);
////        service.removeBook(db, "The Metamorphosis");
//        service.printBooksDetails(db);
//        System.out.println();
//
//        System.out.println("Stergere user");
//        service.printUsersDetails(db);
////        service.removeUser(db, "andrei");
//        service.removeUser(db, "tesla_books");
//        service.printUsersDetails(db);


//         ---------------------MENU-----------------------
        while(true){
            System.out.println("Please type one of the following commands: add / view / person to company(p2c) / exit");
            String line = scanner.nextLine();
            switch (line){
                case "add":
                    System.out.println("book / user / pickup point");
                    String line2 = scanner.nextLine();
                    switch (line2){
                        case "user":
                            System.out.println("Please specify the username");
                            String username = scanner.nextLine();
                            System.out.println("Please specify the password");
                            String password = scanner.nextLine();
                            System.out.println("Please specify the email");
                            String email = scanner.nextLine();

                            System.out.println("Please specify the type: person / company");
                            String type = scanner.nextLine();
                            switch (type) {
                                case "person":
                                    System.out.println("Please specify the first name");
                                    String firstName = scanner.nextLine();
                                    System.out.println("Please specify the last name");
                                    String lastName = scanner.nextLine();
                                    System.out.println("Please specify the delivery address");
                                    String deliveryAddress = scanner.nextLine();
                                    System.out.println("Please specify the phone number");
                                    String phoneNumber = scanner.nextLine();
                                    Person user = new Person(username, password, email, firstName, lastName, deliveryAddress, phoneNumber);
//                                    service.addUser(db, user);
                                    service.addPerson(user);
                                    break;

                                case "company":
                                    System.out.println("Please specify the company name");
                                    String companyName = scanner.nextLine();
                                    System.out.println("Please specify the location");
                                    String location = scanner.nextLine();
                                    System.out.println("Please specify the subscription type");
                                    String subType = scanner.nextLine();
                                    int sub;
                                    switch (subType) {
                                        case "bronze" -> sub = 0;
                                        case "silver" -> sub = 1;
                                        case "gold" -> sub = 2;
                                        default -> throw new IllegalStateException("Unexpected value: " + subType);
                                    }
                                    Company comp = new Company(username, password, email, companyName, location, new Person[50], db.getSubscriptions().get(sub));
                                    service.addCompany(comp);
                                    break;
                            }
                            break;

                        case "book":
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
                            String type2 = scanner.nextLine();
                            switch (type2) {
                                case "digital":
                                    System.out.println("Please specify the format");
                                    String format = scanner.nextLine();
                                    System.out.println("Please specify if the book has a free trial");
                                    String freeTrialString = scanner.nextLine();
                                    boolean freeTrial = Boolean.parseBoolean(freeTrialString);
                                    if (freeTrial) {
                                        System.out.println("Please specify the free trial length");
                                        String lengthString = scanner.nextLine();
                                        int length = Integer.parseInt(lengthString);
                                        DigitalBook book = new DigitalBook(title, author, nrPag, genre, year, stock, format, true, length);
//                                        service.addBook(db, book);
                                        service.addDigitalBook(book);
                                    } else {
                                        DigitalBook book = new DigitalBook(title, author, nrPag, genre, year, stock, format, false);
//                                        service.addBook(db, book);
                                        service.addDigitalBook(book);
                                    }
                                    break;

                                case "physical":
                                    System.out.println("Please specify the cover type");
                                    String cover = scanner.nextLine();
                                    System.out.println("Please specify if the book is new");
                                    String isNewString = scanner.nextLine();
                                    boolean isNew = Boolean.parseBoolean(isNewString);
                                    PhysicalBook book = new PhysicalBook(title, author, nrPag, genre, year, stock, cover, isNew);
//                                    service.addBook(db, book);
                                    service.addPhysicalBook(book);
                                    break;
                            }
                        break;

                        case "pickup point":
                            System.out.println("Please specify the city");
                            String city = scanner.nextLine();
                            System.out.println("Please specify the address");
                            String address = scanner.nextLine();
                            System.out.println("Please specify if opened on weekends");
                            String opened = scanner.nextLine();
                            PickUpPoint pickUpPoint = new PickUpPoint(city, address, Boolean.parseBoolean(opened));
                            service.addPickUpPoint(pickUpPoint);
                            break;

                        default:
                            System.out.println("Invalid type");
                    }
                break;

                case "p2c":
                    System.out.println("Please type the username of the person");
                    String pUsername = scanner.nextLine();

                    System.out.println("Please type the id of the company");
                    String cId = scanner.nextLine();
                    int companyId = Integer.parseInt(cId);

                    service.addPersonToCompany(pUsername, companyId);
                    break;

                case "view":
                    System.out.println("books / users / pickup point");
                    String lineView = scanner.nextLine();
                    switch (lineView){
                        case "books":
                            service.printBooksDetails(db);
                            break;

                        case "users":
                            service.printUsersDetails(db);
                            break;

                        case "pickup point":
                            service.printPickUpPoints(db);
                            break;

                        case "default":
                            System.out.println("Invalid type");
                    }
                    break;

                case "exit" :
//                    rwPerson.write(db.getUsers());
//                    rwPhysicalBook.write(db.getBooks());
//                    rwDigitalBook.write(db.getBooks());
//                    rwCompany.write(db.getUsers());
//                    rwPickUpPoint.write(db.getPickUpPoints());
//                    rwBorrowing.write(db.getBorrowings());
                    System.out.println("Bye bye!");
                    System.exit(0);
                    break;

                default : System.out.println("This command doesn't exist.");

            }
        }

    }
}
