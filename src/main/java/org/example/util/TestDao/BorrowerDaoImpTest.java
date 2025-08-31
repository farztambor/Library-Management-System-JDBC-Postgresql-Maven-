package org.example.util.TestDao;

import org.example.dao.BookDaoImp;
import org.example.dao.BorrowerDao;
import org.example.dao.BorrowerDaoImp;
import org.example.dao.model.Borrower;
import org.junit.Test;

import java.sql.SQLException;

public class BorrowerDaoImpTest {
    @Test
    public void insertTest() throws SQLException {
        BorrowerDaoImp borrowerDaoImp = new BorrowerDaoImp();
        borrowerDaoImp.insert(new Borrower("Queennie", "queennielo@yahoo.com"));

    }
}
