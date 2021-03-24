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

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);

        c.add(Calendar.DATE, 30);
        Date currentDatePlusOne = c.getTime();

        System.out.println(currentDatePlusOne);

        System.out.println(d);

        while(true){
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
        }

//        Book Book1 = new PhysicalBook(1, "Crime and Punishment", "Dostoievski", 500, "mystery",1920,2,2,"Hard",true);
        //String det = scanner.nextLine();
        //String[] att = det.split("/");
//        service.addBook(db, Book1);

//        User user1 = new User(1, "mihaihe", "mihai@gmail.com", "Str. PAO, nr. 242");
//        service.addUser(db, user1);
//        System.out.println(db.getUsers()[0].getName());

    }
}
