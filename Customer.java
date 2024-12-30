package com.g4joey;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;       // Customer's name
    private final String customerId; // Unique ID for customer
    private final List<RentalTransaction> rentalHistory = new ArrayList<>();

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void addRentalTransaction(RentalTransaction transaction) {
        rentalHistory.add(transaction); // Add transaction to history
    }

    public List<RentalTransaction> getRentalHistory() {
        return rentalHistory;
    }
}
