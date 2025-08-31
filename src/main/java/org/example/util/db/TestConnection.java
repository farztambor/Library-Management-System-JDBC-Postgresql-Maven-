package org.example.util.db;

import org.junit.Test;

import java.sql.Connection;

public class TestConnection {
    @Test
    public void tesConnection(){
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {

                System.out.println("✅ Connection successful!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
