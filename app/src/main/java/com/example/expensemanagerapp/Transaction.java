package com.example.expensemanagerapp;

public final class Transaction {
    private final String label;
    private final double amount;

    public final String getLabel() {
        return this.label;
    }

    public final double getAmount() {
        return this.amount;
    }

    public Transaction(String label, double amount) {
        super();
        this.label = label;
        this.amount = amount;
    }

}
