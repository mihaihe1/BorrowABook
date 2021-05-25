package repository;

import config.*;
import model.*;

import javax.swing.text.html.Option;
import java.sql.*;
import java.util.*;

public class PickuppointRepository {

    public void addPickuppoint(PickUpPoint pickUpPoint) {
        String sql = "insert into pickuppoints values (null, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setString(1, pickUpPoint.getCity());
            statement.setString(2, pickUpPoint.getAddress());
            statement.setBoolean(3, pickUpPoint.isOpenedOnWeekends());

            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removePickUpPoint(int id){
//        System.out.println("qqq");
        String sql = "delete from pickuppoints where id = " + id;
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updatePickUpPointAddress(int id, String address){
        String sql = "update pickuppoints set address = ? where id = ?";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setString(1, address);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Optional<PickUpPoint> getPickUpPointById(int id){
        String sql = "select * from pickuppoints where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                //i have at least one record in the result set
                int pointId = result.getInt(1);
                String city = result.getString("city");
                String address = result.getString("address");
                boolean openedOnWeekends = Boolean.parseBoolean(result.getString("openedOnWeekends"));
                return Optional.of(new PickUpPoint(city, address, openedOnWeekends));
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void printPickUpPoints(){
        String sql = "select * from pickuppoints";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while (result.next()){
                String city = result.getString("city");
                String address = result.getString("address");
                boolean openedOnWeekends = result.getBoolean("openedOnWeekends");

                System.out.println(city + " / " + address + " / " + openedOnWeekends + "\n");
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}