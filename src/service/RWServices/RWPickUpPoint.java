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

public class RWPickUpPoint {
    private static final String DIRECTORY_PATH = "resources/data";
    private static final String FILE_PATH = DIRECTORY_PATH + "/pickuppoint.csv";
    private static final RWPickUpPoint INSTANCE = new RWPickUpPoint();

    private RWPickUpPoint() {

    }

    public static RWPickUpPoint getInstance() {
        return INSTANCE;
    }

    public void read(Bookster db, Service service) {
        try {
//            String city, String address, boolean openedOnWeekends)
            BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
            String line = "";
            line = reader.readLine();
            while((line = reader.readLine()) != null) {
                String[] arr = line.split(",");
                String city = arr[0];
                String address = arr[1];
                boolean openedOnWeekends = Boolean.parseBoolean(arr[2]);

                PickUpPoint pickUpPoint = new PickUpPoint(city, address, openedOnWeekends);
                service.addPickUpPoint(db, pickUpPoint);
            }
        } catch (NoSuchFileException e) {
            System.out.println("The file with the name " + FILE_PATH + " doesn't exist.");
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void write(List<PickUpPoint> pickUpPoints) {
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

            writer.write("city,address,opened on weekends\n");
            writer.flush();
            for (PickUpPoint pickUpPoint : pickUpPoints){
                    writer.write(pickUpPoint.getCity() + "," + pickUpPoint.getAddress() + "," + pickUpPoint.isOpenedOnWeekends() + "\n");
                    writer.flush();
                }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}