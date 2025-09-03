package org.example.dao;

import org.example.dao.model.Book;
import org.example.util.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImp implements BookDao{


    @Override
    public Book get(int id) throws SQLException {


        return null;
    }

    @Override
    public List<Book> getAll() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try(Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql)){
            while (rs.next()){
                Book book = new Book(
                        rs.getInt("id"),
                                rs.getString("title") ,
                                rs.getString("author") ,
                                rs.getBoolean("available"));
                books.add(book);
            }

        }
        catch (Exception e){
            throw new SQLException(e);
        }


        return books;
    }

    @Override
    public void save(Book book) throws SQLException {

    }

    @Override
    public void insert(Book book) throws SQLException {
        String sql = "INSERT INTO books (title, author, available) VALUES (?, ?, ?)";
        try(Connection conn = DBConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1,book.getTitle());
            statement.setString(2,book.getAuthor());
            statement.setBoolean(3,book.isAvailable());
            statement.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Book book) throws SQLException {

    }

    @Override
    public void delete(Book book) throws SQLException {

    }
}
