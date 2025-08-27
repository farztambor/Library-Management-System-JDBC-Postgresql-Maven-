package org.example.util.db;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args){
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Connection successful!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
