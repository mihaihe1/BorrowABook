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

    public Optional<Company> getCompanyById(int id){
        String sql = "select * from companies where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                //i have at least one record in the result set

                String username = result.getString("userName");
                String password = result.getString("password");
                String email = result.getString("email");
                String companyName = result.getString("companyName");
                String location = result.getString("location");
                return Optional.of(new Company(username, password, email, companyName, location));
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void updateCompanyLocation(int id, String location){
        String sql = "update companies set location = ? where id = ?";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setString(1, location);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}