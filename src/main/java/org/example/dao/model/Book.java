package org.example.dao.model;

public class Book {

    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book (int id , String title, String author, boolean available){
        this.id = id;
        this.title=title;
        this.author =author;
        this.available=available;
    }

    public Book(String title, String author){
        this.title =title;
        this.author = author;
        this.available= true;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title=" + title +
                ", author=" + author +
                ", available=" + available +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return true;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
