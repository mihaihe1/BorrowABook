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
import java.util.List;
import java.util.Set;

public class RWPhysicalBook {
    private static final String DIRECTORY_PATH = "resources/data";
    private static final String FILE_PATH = DIRECTORY_PATH + "/physicalbook.csv";
    private static final RWPhysicalBook INSTANCE = new RWPhysicalBook();

    private RWPhysicalBook() {

    }

    public static RWPhysicalBook getInstance() {
        return INSTANCE;
    }

    public void read(Bookster db, Service service) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
            String line = "";
            line = reader.readLine();
            while((line = reader.readLine()) != null) {
                String[] arr = line.split(",");
                String title = arr[0];
                String author = arr[1];
                int pageNumber = Integer.parseInt(arr[2]);
                String genre = arr[3];
                int publicationYear = Integer.parseInt(arr[4]);
                int stock = Integer.parseInt(arr[5]);
                String coverType = arr[6];
                boolean isNew = Boolean.parseBoolean(arr[7]);

                PhysicalBook book = new PhysicalBook(title, author, pageNumber, genre, publicationYear, stock, coverType, isNew);
                service.addPhysicalBook(book);
            }
        } catch (NoSuchFileException e) {
            System.out.println("The file with the name " + FILE_PATH + " doesn't exist.");
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void write(Set<Book> books) {
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
//            String title, String author, int pageNumber, String genre, int publicationYear, int stock, String coverType, boolean isNew

            writer.write("title,author,page number,genre,publication year,stock,cover type,is new\n");
            writer.flush();
            for (Book book : books)
                if (book instanceof PhysicalBook){
                    writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getPageNumber() + "," +
                            book.getGenre() + "," + book.getPublicationYear() + "," + book.getStock() + "," + ((PhysicalBook) book).getCoverType()
                            +"," + ((PhysicalBook) book).isNew() + "\n");
                    writer.flush();
                }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
