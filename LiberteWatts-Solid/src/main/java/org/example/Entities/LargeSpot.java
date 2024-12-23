package org.example.Entities;

public class LargeSpot extends ParkingSpot{
    @Override
    public boolean isVehicleCompatible(Vehicle vehicle) {
        return vehicle instanceof Van || vehicle instanceof Car || vehicle instanceof Motorcycle;
    }
}
