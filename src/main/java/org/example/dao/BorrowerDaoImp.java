package org.example.dao;

import org.example.dao.model.Borrower;
import org.example.util.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BorrowerDaoImp implements BorrowerDao {
    @Override
    public Borrower get(int id) throws SQLException {
    return  null;
    }

    @Override
    public List<Borrower> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void save(Borrower borrower) throws SQLException {

    }

    @Override
    public void insert(Borrower borrower) throws SQLException {
        String sql = "Insert into borrowers (name,email) VALUES(?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, borrower.getName());
            statement.setString(2, borrower.getEmail());
            statement.executeUpdate();

        } catch (Exception e) {
            throw new SQLException(e);
        }

    }

    @Override
    public void update(int t) throws SQLException {

    }

    @Override
    public void delete(int t) throws SQLException {

    }
}