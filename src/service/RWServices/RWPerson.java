package service.RWServices;

import model.Bookster;
import model.Person;
import model.User;
import service.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class RWPerson {
    private static final String DIRECTORY_PATH = "resources/data";
    private static final String FILE_PATH = DIRECTORY_PATH + "/user.csv";
    private static final RWPerson INSTANCE = new RWPerson();

    private RWPerson() {

    }

    public static RWPerson getInstance() {
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
                String firstName = arr[3];
                String lastName = arr[4];
                String deliveryAddress = arr[5];
                String phoneNumber = arr[6];

                User user = new Person(username, password, email, firstName, lastName, deliveryAddress, phoneNumber);
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
            writer.write("username,password,email,firstname,lastname,delivery address,phone number\n");
            writer.flush();
            for (User user : users)
                if (user instanceof Person){
                    writer.write(user.getUserName() + "," + user.getPassword() + "," + user.getEmail() + "," + ((Person) user).getFirstName()
                    + "," + ((Person) user).getLastName() + "," + ((Person) user).getDeliveryAddress() + "," + ((Person) user).getPhoneNumber()+"\n");
                    writer.flush();
                }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
