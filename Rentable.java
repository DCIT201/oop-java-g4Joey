package com.g4joey;

public interface Rentable {
    // To rent a vehicle
    void rent(Customer customer, int days);

    // To return a vehicle
    void returnVehicle();
}
