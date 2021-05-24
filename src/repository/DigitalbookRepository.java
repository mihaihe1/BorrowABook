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

    public void rateDigitalBook(User user, DigitalBook book, int rating){
        String sql = "update digitalbooks set userRating = ?,nrRatings = ? where id = ?";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            int bookId = getBookId(book);
            double ratingActual = getRating(bookId);
            int nrRatings = getNrRatings(bookId);
            double newRating = ((ratingActual * nrRatings) + rating) / (nrRatings+1);
            statement.setDouble(1, newRating);
            statement.setInt(2, nrRatings+1);
            statement.setInt(3, bookId);

            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getBookId(DigitalBook book){
        String sql = "select * from digitalbooks where title = ?";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            ResultSet result = statement.executeQuery();
            while (result.next()){
                int id = result.getInt("id");
                return id;
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double getRating(int id){
        String sql = "select * from digitalbooks where id = ?";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                double rating = result.getDouble("userRating");
                return rating;
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getNrRatings(int id){
        String sql = "select * from digitalbooks where id = ?";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                int nr = result.getInt("nrRatings");
                return nr;
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}