package org.example.dao;

import org.example.dao.model.Transaction;

import java.sql.SQLException;

public interface TransactionDao extends DaoGeneric<Transaction>{

    void update(Transaction transaction) throws SQLException;

    void delete(Transaction transaction) throws SQLException;
}
