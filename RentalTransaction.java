package com.g4joey;

public class RentalTransaction {
    private final Vehicle vehicle; // The rented vehicle
    private final int rentalDays;  // How many days it was rented
    private final double totalCost; // Total cost of rental

    public RentalTransaction(Vehicle vehicle, int rentalDays) {
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.totalCost = vehicle.calculateRentalCost(rentalDays); // Calculate cost on creation
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return String.format("%s rented for %d days. Total cost: $%.2f", vehicle, rentalDays, totalCost);
    }
}
