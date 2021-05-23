package repository;

import config.*;
import model.*;

import java.sql.*;
import java.util.*;

public class DigitalbookRepository {

    public void addDigitalBook(DigitalBook book) {
        String sql = "insert into digitalbooks values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getPageNumber());
            statement.setString(4, book.getGenre());
            statement.setInt(5, book.getPublicationYear());
            statement.setDouble(6, 0);
            statement.setInt(7, 0);
            statement.setInt(8, book.getStock());
            statement.setString(9, book.getFormat());
            statement.setBoolean(10, book.isFreeTrial());
            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteDigitalBook(int id){
        String sql = "delete from digitalbooks where id = " + id;
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}