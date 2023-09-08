package com.example.expensemanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Transaction> transactions;
    private TransactionAdapter transactionAdapter;
    private LinearLayoutManager linearLayoutManager;
//    private TextView balance;
//    private TextView budget;
//    private TextView expense;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transactions = new ArrayList<>();
        transactions.add(
                new Transaction("WeeklyBudget", 400)
        );
        transactions.add(
                new Transaction("Lunch", -50)
        );

        transactionAdapter = new TransactionAdapter(transactions);
        linearLayoutManager = new LinearLayoutManager(this);

//        db = Room.databaseBuilder(this, AppDatabase.class, "transactions").build();

        RecyclerView recyclerView = findViewById(R.id.recyclerview); // Assuming R.id.recyclerview is the ID of your RecyclerView in XML.
        recyclerView.setAdapter(transactionAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        updateDashboard();
    }

    private void updateDashboard() {
        double totalAmount = 0.0;
        double budgetAmount = 0.0;

        for (Transaction transaction : transactions) {
            totalAmount += transaction.getAmount();
            if (transaction.getAmount() > 0) {
                budgetAmount += transaction.getAmount();
            }
        }

        double expenseAmount = totalAmount - budgetAmount;

        TextView balance = findViewById(R.id.balance);

        TextView budget = findViewById(R.id.budget);
        TextView expense = findViewById(R.id.expense);

        balance.setText(String.format("$ %.2f", totalAmount));
        budget.setText(String.format("$ %.2f", budgetAmount));
        expense.setText(String.format("$ %.2f", expenseAmount));
    }

}