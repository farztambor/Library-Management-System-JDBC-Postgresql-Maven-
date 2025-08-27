package org.example.util.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String JDBCURL= "jdbc:postgresql://localhost:5432/LibraryDb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(JDBCURL,USER,PASSWORD);
    }


}
