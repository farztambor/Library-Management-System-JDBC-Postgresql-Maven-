package org.example.dao.model;


public class Borrower {

    private int id;
    private String name;
    private String email;

    public Borrower(int id ,String name, String email ){
        this.id=id;
        this.name=name;
        this.email=email;
    }

    public Borrower(String name, String email){
        this.name = name ;
        this.email =email;
    }

    public void setName(String name ){
        this.name = name;
    }
    public String getName(){
        return  this.name = name;
    }

    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email = email;
    }
}

