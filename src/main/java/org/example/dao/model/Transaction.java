package org.example.dao.model;
import java.time.LocalDate;

public class Transaction {
    private int id;
    private int bookId;
    private int borrowerId;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Transaction(int id, int bookId, int borrowerId, LocalDate issueDate, LocalDate returnDate){
        this.id = id;
        this.bookId= bookId;
        this.borrowerId = borrowerId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public Transaction(int bookId, int borrowerId, LocalDate issueDate, LocalDate returnDate){
        this.borrowerId = borrowerId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public int getId(){return id;}
    public int getBookId() {return bookId;};
    public int getBorrowerId(){return borrowerId;};
    public LocalDate getIssueDate(){return issueDate;}
    public LocalDate getReturnDate(){return returnDate;}

    public void setId(int id) {
        this.id = id;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
