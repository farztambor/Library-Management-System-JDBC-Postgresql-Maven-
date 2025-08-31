package org.example.dao;

import org.example.dao.model.Borrower;
import org.example.util.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BorrowerDaoImp implements BorrowerDao{
    @Override
    public Borrower get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Borrower> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public int save(Borrower borrower) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Borrower borrower) throws SQLException {
        String sql = "Insert into borrowers (name,email) VALUES(?, ?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, borrower.getName());
            statement.setString(2, borrower.getEmail());
            statement.executeUpdate();

        }catch (Exception e){
            throw new SQLException(e);
        }
        return 0;
    }

    @Override
    public int update(Borrower borrower) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Borrower borrower) throws SQLException {
        return 0;
    }
}
