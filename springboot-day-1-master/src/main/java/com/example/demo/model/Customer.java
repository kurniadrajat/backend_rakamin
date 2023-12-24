package com.example.demo.model;

public class Customer {
    private Long id;
    private String name;
    private double balance;

// Siswa: Lengkapi dengan konstruktor, getters, dan setters

    public Customer(Long id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
