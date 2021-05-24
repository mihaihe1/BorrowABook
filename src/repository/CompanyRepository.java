package repository;

import config.*;
import model.*;

import java.sql.*;
import java.util.*;

public class CompanyRepository {

    public void addCompany(Company company) {
        String sql = "insert into companies values (null, ?, ?, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setString(1, company.getUserName());
            statement.setString(2, company.getPassword());
            statement.setString(3, company.getEmail());
            statement.setString(4, company.getCompanyName());
            statement.setString(5, company.getLocation());

            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeCompany(String username){
        String sql = "delete from companies where username = ?";
        System.out.println(sql);
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setString(1, username);
            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}