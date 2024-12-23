package org.example.Entities;

public class MotorcycleSpot extends ParkingSpot {
    @Override
    public boolean isVehicleCompatible(Vehicle vehicle) {
        return true;
    }
}
