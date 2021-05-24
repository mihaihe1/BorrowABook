package repository;

import config.*;
import model.*;

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
}