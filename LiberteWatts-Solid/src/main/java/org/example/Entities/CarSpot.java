package org.example.Entities;

public class CarSpot extends ParkingSpot{
    @Override
    public boolean isVehicleCompatible(Vehicle vehicle) {
        return vehicle instanceof Car || vehicle instanceof Motorcycle || vehicle instanceof Van;
    }
}
