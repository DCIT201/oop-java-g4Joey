package com.g4joey;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RentalAgency {
    private final List<Vehicle> fleet = new ArrayList<>();

    public RentalAgency() {
        // Adding vehicles
        fleet.add(new Car("C001", "Toyota Corolla", 50));
        fleet.add(new Car("C002", "Honda Civic", 45));
        fleet.add(new Car("C003", "Ford Focus", 40));
        fleet.add(new Car("C004", "BMW 3 Series", 75));
        fleet.add(new Car("C005", "Audi A4", 80));

        fleet.add(new Motorcycle("M001", "Yamaha MT-07", 30));
        fleet.add(new Motorcycle("M002", "Kawasaki Ninja", 40));
        fleet.add(new Motorcycle("M003", "Harley Davidson", 50));
        fleet.add(new Motorcycle("M004", "Ducati Monster", 60));
        fleet.add(new Motorcycle("M005", "Suzuki GSX", 35));

        fleet.add(new Truck("T001", "Ford F-150", 100));
        fleet.add(new Truck("T002", "Ram 1500", 120));
        fleet.add(new Truck("T003", "Chevrolet Silverado", 110));
        fleet.add(new Truck("T004", "Toyota Tundra", 115));
        fleet.add(new Truck("T005", "Nissan Titan", 105));
    }

    public void displayAvailableVehicles() {
        System.out.println("\nAvailable Vehicles:");
        fleet.stream()
                .filter(Vehicle::isAvailable)
                .sorted(Comparator.comparing(Vehicle::getModel))
                .forEach(vehicle -> System.out.printf("[%s] %s%n", vehicle.getVehicleId(), vehicle));
    }

    public Vehicle findVehicleByIdOrModel(String input) {
        return fleet.stream()
                .filter(v -> v.getVehicleId().equalsIgnoreCase(input)
                        || v.getModel().toLowerCase().contains(input.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public List<Vehicle> findVehiclesByPartialNameOrId(String input) {
        return fleet.stream()
                .filter(v -> v.isAvailable() &&
                        (v.getVehicleId().equalsIgnoreCase(input) ||
                                v.getModel().toLowerCase().contains(input.toLowerCase())))
                .collect(Collectors.toList());
    }

    public List<Vehicle> getAvailableVehicles() {
        return fleet.stream()
                .filter(Vehicle::isAvailable)
                .toList();
    }
}
