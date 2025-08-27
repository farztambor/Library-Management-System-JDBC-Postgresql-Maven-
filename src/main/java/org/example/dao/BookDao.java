package org.example.dao;

import org.example.dao.model.Book;
import org.example.util.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public void addBook(Book book) throws SQLException{
        String sql = "INSERT INTO  books (title,author,available) VALUES (?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setBoolean(3, book.isAvailable());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getAllBooks() throws Exception{
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()){
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("available")
                ));
            }

        }
        return books;
    }


}
