package config;

import java.sql.*;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection () {

    }

    public static Connection getInstance() throws SQLException, ClassNotFoundException {
        if(connection == null) {
            String url = "jdbc:mysql://localhost:3306/pao_tema";
            String username = "root";
            String password = "1234";
//            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
