package com.g4joey;

public abstract class Vehicle {
    private final String vehicleId; // Unique ID for the vehicle
    private String model;           // Vehicle model name
    private double baseRentalRate;  // Rental rate per day
    private boolean isAvailable;    // Availability status

    public Vehicle(String vehicleId, String model, double baseRentalRate) {
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Rental rate has to be positive.");
        }
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true; // By default, vehicle is available
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Rental rate must be positive.");
        }
        this.baseRentalRate = baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Abstract methods to define in subclasses
    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();

    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f per day", model, vehicleId, baseRentalRate);
    }
}
