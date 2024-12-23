package org.example.Entities;

public class Motorcycle extends Vehicle{
    private static final int REQUIRED_SPOTS = 1;
    public Motorcycle() {
        super(REQUIRED_SPOTS);
    }
    @Override
    public boolean isCompatibleWithSpot(ParkingSpot parkingSpot) {
        return true;
    }
}
