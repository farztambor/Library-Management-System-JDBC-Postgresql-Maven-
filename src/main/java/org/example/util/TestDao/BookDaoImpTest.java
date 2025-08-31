package org.example.util.TestDao;

import org.example.dao.BookDaoImp;
import org.example.dao.model.Book;
import org.junit.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDaoImpTest {
    @Test
    public void insertTest() throws SQLException {
        BookDaoImp bdao = new BookDaoImp();

        bdao.insert(new Book("Swerte","Raffie2"));


    }

    @Test
    public void getAllTest() throws  SQLException{
        List<Book> books = new ArrayList<>();
        BookDaoImp bookDaoImp = new BookDaoImp();
        books = bookDaoImp.getAll();


        for (Book b : books){
            System.out.println(b.toString());
        }


    }


}
