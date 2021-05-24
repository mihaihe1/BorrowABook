package repository;

import config.*;
import model.*;

import java.sql.*;
import java.util.*;

public class PersonRepository {

    public void addPerson(Person person) {
        String sql = "insert into persons values (null, ?, ?, ?, ?, ?, ?, ?, null) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setString(1, person.getUserName());
            statement.setString(2, person.getPassword());
            statement.setString(3, person.getEmail());
            statement.setString(4, person.getFirstName());
            statement.setString(5, person.getLastName());
            statement.setString(6, person.getDeliveryAddress());
            statement.setString(7, person.getPhoneNumber());
//            statement.setNull(8);

            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removePerson(String username){
        String sql = "delete from persons where username = ?";
//        System.out.println(sql);
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setString(1, username);
            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addPersonToCompany(String username, int id){
        String sql = "update persons set id_company = ? where userName = ?";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setInt(1, id);
            statement.setString(2, username);
            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}