package com.g4joey;

import java.util.List;
import java.util.Scanner;

public class RentalSystem {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        Customer customer = new Customer("Joshua Azu", "L12345");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. See Available Vehicles");
            System.out.println("2. Rent a Vehicle");
            System.out.println("3. Check Rental History");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clears newline

            if (choice == 1) {
                agency.displayAvailableVehicles();
            } else if (choice == 2) {
                // Show available vehicles first
                List<Vehicle> availableVehicles = agency.getAvailableVehicles();
                if (availableVehicles.isEmpty()) {
                    System.out.println("Oops, no vehicles available right now!");
                } else {
                    System.out.println("\nHere are the available vehicles:");
                    for (int i = 0; i < availableVehicles.size(); i++) {
                        System.out.printf("%d. %s%n", i + 1, availableVehicles.get(i));
                    }

                    // Ask for input
                    System.out.print("Enter the ID, full name, part of the name, or number of the vehicle: ");
                    String input = scanner.nextLine().trim();
                    List<Vehicle> matches = agency.findVehiclesByPartialNameOrId(input);

                    if (matches.isEmpty()) {
                        System.out.println("Sorry, couldn't find a match for that.");
                    } else if (matches.size() == 1) {
                        // If one match, select it
                        Vehicle chosenVehicle = matches.get(0);
                        System.out.printf("You picked: %s%n", chosenVehicle);

                        System.out.print("How many days do you want to rent it for? ");
                        int days = scanner.nextInt();
                        scanner.nextLine();

                        customer.addRentalTransaction(new RentalTransaction(chosenVehicle, days));
                        chosenVehicle.setAvailable(false);
                        System.out.println("Congrats! Vehicle rented.");
                    } else {
                        // Multiple matches
                        System.out.println("\nFound several matches. Please pick one:");
                        for (int i = 0; i < matches.size(); i++) {
                            System.out.printf("%d. %s%n", i + 1, matches.get(i));
                        }

                        System.out.print("Pick the number of the vehicle you want: ");
                        int selectedNumber = scanner.nextInt();
                        scanner.nextLine();

                        if (selectedNumber >= 1 && selectedNumber <= matches.size()) {
                            Vehicle chosenVehicle = matches.get(selectedNumber - 1);
                            System.out.printf("You picked: %s%n", chosenVehicle);

                            System.out.print("How many days do you want to rent it for? ");
                            int days = scanner.nextInt();
                            scanner.nextLine();

                            customer.addRentalTransaction(new RentalTransaction(chosenVehicle, days));
                            chosenVehicle.setAvailable(false);
                            System.out.println("Congrats! Vehicle rented.");
                        } else {
                            System.out.println("Invalid number, please try again.");
                        }
                    }
                }
            } else if (choice == 3) {
                System.out.println("\nYour Rental History:");
                customer.getRentalHistory().forEach(System.out::println);
            } else if (choice == 4) {
                System.out.println("Goodbye! Thanks for using the rental system.");
                break;
            } else {
                System.out.println("That option doesn't exist. Try again.");
            }
        }
        scanner.close();
    }
}
