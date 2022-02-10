package com.example.testingdemo;

public class BankAccount {
    private String name;
    private double balance;
    private double minimumBalance;

    public BankAccount(String name, double balance, double minimumBalance) {
        this.name = name;
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    public BankAccount() {
    }

    public double withdraw(double amount) {
        if((balance - amount) < minimumBalance) {
            throw new RuntimeException();
        }
        balance = balance - amount;
        return balance;
    }

    public double deposit(double amount) {
        balance = balance + amount;
        return balance;
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

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
