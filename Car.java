package com.g4joey;

public class Car extends Vehicle {
    public Car(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days; // Simple cost calculation
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable(); // Check if available
    }
}
