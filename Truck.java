package com.g4joey;

public class Truck extends Vehicle {
    private static final double EXTRA_INSURANCE_FEE = 50.00; // Additional cost for insurance

    public Truck(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRentalRate() * days) + EXTRA_INSURANCE_FEE; // Add extra fee
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable(); // Check availability
    }
}
