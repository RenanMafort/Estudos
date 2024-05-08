package br.com.devdojo.varargs.jdbc.conn;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //java.sql = Connection, ResultSet, DriverManager


    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/repository";
        String username = "root";
        String password = "1010";

        return DriverManager.getConnection(url, username, password);

    }

    public static JdbcRowSet getjdbcRowSet() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/repository";
        String username = "root";
        String password = "1010";
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        jdbcRowSet.setUrl(url);
        jdbcRowSet.setUsername(username);
        jdbcRowSet.setPassword(password);
        return jdbcRowSet;

    }

    public static CachedRowSet getCachedRowSet() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/repository";
        String username = "root";
        String password = "1010";
        CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        cachedRowSet.setUrl(url);
        cachedRowSet.setUsername(username);
        cachedRowSet.setPassword(password);
        return cachedRowSet;

    }

}
