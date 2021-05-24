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

public class RWCompany {
    private static final String DIRECTORY_PATH = "resources/data";
    private static final String FILE_PATH = DIRECTORY_PATH + "/company.csv";
    private static final RWCompany INSTANCE = new RWCompany();

    private RWCompany() {

    }

    public static RWCompany getInstance() {
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
                String password = arr[1];
                String email = arr[2];
                String companyName = arr[3];
                String location = arr[4];
                String subscription = arr[5];
                int type;
                switch (subscription) {
                    case "bronze" -> type = 0;
                    case "silver" -> type = 1;
                    case "gold" -> type = 2;
                    default -> throw new IllegalStateException("Unexpected value: " + subscription);
                }

                User user = new Company(username, password, email, companyName, location);
                service.addUser(db, user);
            }
        } catch (NoSuchFileException e) {
            System.out.println("The file with the name " + FILE_PATH + " doesn't exist.");
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void write(List<User> users) {
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
            writer.write("username,password,email,company name,location,subscription\n");
            writer.flush();
            for (User user : users)
                if (user instanceof Company){
                    writer.write(user.getUserName() + "," + user.getPassword() + "," + user.getEmail() + "," + ((Company) user).getCompanyName()
                            + "," + ((Company) user).getLocation() + "\n");
                    writer.flush();
                }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
