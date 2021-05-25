package repository;

import config.*;
import model.*;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class BorrowingRepository {
    public void addBorrowing(Borrowing borrowing) {
        String sql = "insert into borrowings values (?, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setInt(1, getPersonId(borrowing.getUser()));
            statement.setInt(2, getBookId(borrowing.getBook()));
            statement.setDate(3, java.sql.Date.valueOf(borrowing.getStartingDate()));
            statement.setDate(4, java.sql.Date.valueOf(borrowing.getEndingDate()));

            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getBookId(Book book){
        String sql = "select * from physicalbooks where title = ?";
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

    public int getPersonId(User user){
        String sql = "select * from persons where username = ?";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, user.getUserName());
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

    public void removeBorrowing(int id_user, int id_book){
        String sql = "delete from borrowings where id_user = ? and id_book = ?";
        System.out.println(sql);
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setInt(1, id_user);
            statement.setInt(2, id_book);

            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(int id_user, int id_book, int newBookId){
        String sql = "update borrowings set id_book = ? where id_user = ? and id_book = ?";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setInt(1, newBookId);
            statement.setInt(2, id_user);
            statement.setInt(3, id_book);

            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printBorrowingsDetails(){
        String sql = "select * from borrowings";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while (result.next()){
                int id_user = result.getInt("id_user");
                int id_book = result.getInt("id_book");
                Date startingDate = result.getDate("starting_date");
                Date endingDate = result.getDate("ending_date");
                System.out.println(id_user + " / " + id_book + " / " + startingDate + " / " + endingDate + "\n");
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}