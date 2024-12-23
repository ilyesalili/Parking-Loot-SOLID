package org.example;

import org.example.Entities.*;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(1, 7, 0);

        Vehicle motorcycle = new Motorcycle();
        Vehicle car = new Car();
        Vehicle car2 = new Car();
        Vehicle car3 = new Car();
        Vehicle van = new Van();

        System.out.println("Parking motorcycle: " + parkingLot.parkVehicle(motorcycle));
        System.out.println("Parking car: " + parkingLot.parkVehicle(car));
        System.out.println("Parking car: " + parkingLot.parkVehicle(car2));
        System.out.println("Parking car: " + parkingLot.parkVehicle(car3));
        System.out.println("Parking van: " + parkingLot.parkVehicle(van));

        System.out.println("Remaining spots: " + parkingLot.getRemainingSpots());
        System.out.println("Parking lot full: " + parkingLot.isFull());

        // Leaving vehicles
        parkingLot.leaveVehicle(motorcycle);
        System.out.println("Motorcycle left. Remaining spots: " + parkingLot.getRemainingSpots());

        parkingLot.leaveVehicle(car);
        System.out.println("Car left. Remaining spots: " + parkingLot.getRemainingSpots());

        parkingLot.leaveVehicle(van);
        System.out.println("Van left. Remaining spots: " + parkingLot.getRemainingSpots());

        System.out.println("Parking lot empty: " + parkingLot.isEmpty());
    }
}