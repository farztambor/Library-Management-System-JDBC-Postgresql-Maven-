package org.example.dao;

import org.example.dao.model.Transaction;
import org.example.util.db.DBConnection;

import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImp implements TransactionDao {


    @Override
    public Transaction get(int id) throws SQLException {
        String sql = "SELECT id, name , email from borrowers WHERE id = ?";
        Transaction transaction = null;
        try(Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ){
            transaction.setId(rs.getInt("id"));
            transaction.setBookId(rs.getInt("book_id"));
            transaction.setBorrowerId(rs.getInt("borrower_id"));
            transaction.setIssueDate(rs.getDate("issue_date").toLocalDate());
            transaction.setReturnDate(rs.getDate("return_date").toLocalDate());

        }catch (Exception e){
            throw new RuntimeException(e);
        }



            return transaction;

    }


    @Override
    public List<Transaction> getAll() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * from transactions";

        try(Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ){
            while (rs.next()){
                transactions.add(new Transaction(
                        rs.getInt("id"),
                        rs.getInt("book_id"),
                        rs.getInt("borrwer_id"),
                        rs.getDate("issue_date").toLocalDate(),
                        rs.getDate("return_date") != null ? rs.getDate("return_date").toLocalDate() : null
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }

    @Override
    public void save(Transaction transaction) throws SQLException {

    }



    public  void issueBook(int bookId, int borrowerId) throws Exception {
        String sql = "INSERT INTO transactions (book_id, borrower_id, issue_date) VALUES (?,?,?)";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
        ){
            statement.setInt(1, bookId);
            statement.setInt(2,borrowerId);
            statement.setDate(3, Date.valueOf(LocalDate.now()));
            statement.executeUpdate();

        }

        String updateBook = "UPDATE books SET available = false WHERE id = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(updateBook)
        ){
            statement.setInt(1, bookId);
            statement.executeUpdate();
        }
    }

    public void returnBook(int transactionId) throws Exception {
        //update transaction return date
        String sql = "Update transactions SET return_date = ? WHERE id = ?";
        int bookId = -1;

        try(Connection conn =  DBConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ){
            statement.setDate(1, Date.valueOf(LocalDate.now()));
            statement.setInt(2, transactionId);
            statement.executeUpdate();
        }

        //Get bookId for this transaction
        String findBook = "Select book_id FROM transactions WHERE id =?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement statement= conn.prepareStatement(findBook);
        ){
            statement.setInt(1,transactionId);

            try(ResultSet rs = statement.executeQuery()){
                if(rs.next()){
                    bookId= rs.getInt("book_id");
                }
            }

        }

        // Mark book available again
        if(bookId!=-1){
            String updateBook = "UPDATE books SET available = true WHERE id =?";
            try(Connection conn = DBConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(updateBook)
            ){
                statement.setInt(1, bookId);
                statement.executeUpdate();
            }
        }
    }


    @Override
    public void insert(Transaction transaction) throws SQLException {
//        String sql = "INSERT INTO transactions(book_id, borrower_id, issue_date) VALUES (?, ?, ?)";
//        try(Connection con = DBConnection.getConnection();
//            PreparedStatement statement = con.prepareStatement(sql);
//        ){
//            statement.setInt(1,transaction.getBookId());
//            statement.setInt(2,transaction.getBorrowerId());
//            statement.setDate(3, Date.valueOf(LocalDate.now()));
//            statement.executeUpdate();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void update(int t) throws SQLException {

    }

    @Override
    public void delete(int t) throws SQLException {

    }

    @Override
    public void update(Transaction transaction) throws SQLException {

    }

    @Override
    public void delete(Transaction transaction) throws SQLException {

    }
}
