package com.example.personal_finance.expense;


import java.time.OffsetDateTime;

public class Expense {

    private int id;
    private double amount;
    private String business;
    private String product;
    private int userId;
    private OffsetDateTime dateTime;


    public Expense(int id, double amount, String business, String product, int userId, OffsetDateTime dateTime) {
        this.id = id;
        this.amount = amount;
        this.business = business;
        this.product = product;
        this.userId = userId;
        this.dateTime = dateTime;

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBusiness() {
        return this.business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public OffsetDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(OffsetDateTime date_time) {
        this.dateTime = date_time;
    }

}


