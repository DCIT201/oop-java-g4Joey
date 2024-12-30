package com.g4joey;

public class Motorcycle extends Vehicle {
    public Motorcycle(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days > 5) {
            return getBaseRentalRate() * days * 0.9; // 10% discount for rentals over 5 days
        }
        return getBaseRentalRate() * days;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable(); // Check availability
    }
}
