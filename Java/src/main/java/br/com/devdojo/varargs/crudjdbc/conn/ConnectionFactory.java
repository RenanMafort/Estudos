package br.com.devdojo.varargs.crudjdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/repository";
        String username = "root";
        String password = "1010";

        return DriverManager.getConnection(url,username,password);
    }
}
