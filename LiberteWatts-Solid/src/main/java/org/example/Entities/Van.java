package org.example.Entities;

public class Van extends Vehicle{
    private static final int REQUIRED_SPOTS = 3;
    public Van() {
        super(REQUIRED_SPOTS);
    }
    @Override
    public boolean isCompatibleWithSpot(ParkingSpot parkingSpot) {
        return parkingSpot instanceof LargeSpot || parkingSpot instanceof CarSpot;
    }
}
