package service.RWServices;

import model.*;
import service.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.List;

public class RWBorrowing {
    private static final String DIRECTORY_PATH = "resources/data";
    private static final String FILE_PATH = DIRECTORY_PATH + "/borrowing.csv";
    private static final RWBorrowing INSTANCE = new RWBorrowing();

    private RWBorrowing() {

    }

    public static RWBorrowing getInstance() {
        return INSTANCE;
    }

    public void read(Bookster db, Service service) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
            String line = "";
            line = reader.readLine();
            while((line = reader.readLine()) != null) {
                String[] arr = line.split(",");
                String username = arr[0];
                String bookTitle = arr[1];
                User u = service.searchUser(db, username);
                if (u == null){
                    System.out.println("The user doesn't exist");
                    return;
                }
//
//
//                Borrowing borrowing = new Borrowing(u, b);
//                service.addBorrowing(borrowing);
            }
        } catch (NoSuchFileException e) {
            System.out.println("The file with the name " + FILE_PATH + " doesn't exist.");
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void write(List<Borrowing> borrowings) {
        if(!Files.exists(Paths.get(DIRECTORY_PATH))) {
            try {
                Files.createDirectories(Paths.get(DIRECTORY_PATH));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        if(!Files.exists(Paths.get(FILE_PATH))) {
            try {
                Files.createFile(Paths.get(FILE_PATH));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH),
                    StandardOpenOption.TRUNCATE_EXISTING);

            writer.write("username,book title, starting date, ending date\n");
            writer.flush();
            for (Borrowing b : borrowings){
                    writer.write(b.getUser().getUserName() + "," + b.getBook().getTitle() + "," + b.getStartingDate() + "," + b.getEndingDate() + "\n");
                    writer.flush();
                }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
