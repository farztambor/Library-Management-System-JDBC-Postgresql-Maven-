package org.example.dao;

import java.sql.SQLException;
import java.util.List;

public interface DaoGeneric<T> {

    T get(int id) throws SQLException;
    List<T> getAll() throws SQLException;
    void save(T t) throws SQLException;
    void insert(T t) throws  SQLException;
    void update(int t) throws SQLException;
    void delete(int t) throws SQLException;
}
