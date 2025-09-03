package org.example.ui;



import org.example.dao.TransactionDaoImp;

import javax.print.attribute.standard.JobName;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LibraryUI extends JFrame {

    private JTextField bookIdField;
    private JTextField borrowerIdField;
    private JTextField transactionIdField;
    private TransactionDaoImp transactionDaoImp;

    public LibraryUI(){
        transactionDaoImp = new TransactionDaoImp();

        setTitle("Library Management System");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6,2));

        //fields
        add(new JLabel("Book ID:"));
        bookIdField= new JTextField();
        add(bookIdField);

        add(new JLabel("Borrower ID:"));
        borrowerIdField = new JTextField();
        add(borrowerIdField);

        JButton issueButton = new JButton("Issue Book");
        issueButton.addActionListener(e -> issueBook());
        add(issueButton);

        add(new JLabel("Transaction ID (for return): "));
        transactionIdField = new JTextField();
        add(transactionIdField);

        JButton returnButton = new JButton("Return Book");
        returnButton.addActionListener(e-> returnBook());
        add(returnButton);

        setVisible(true);
    }

    private void issueBook(){
        try{
            int bookId = Integer.parseInt(bookIdField.getText());
            int borrowerId = Integer.parseInt(borrowerIdField.getText());
            transactionDaoImp.issueBook(bookId, borrowerId);
            JOptionPane.showMessageDialog(this, "Book issued successfully!");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error issuing  book");
        }
    }

    private void returnBook() {
        try {
            int transactionId = Integer.parseInt(transactionIdField.getText());
            transactionDaoImp.returnBook(transactionId);
            JOptionPane.showMessageDialog(this, "Book returned successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error returning book!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
