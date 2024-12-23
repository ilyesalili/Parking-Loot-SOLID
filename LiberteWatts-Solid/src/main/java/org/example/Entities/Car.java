package org.example.Entities;

public class Car extends Vehicle{

    private static final int REQUIRED_SPOTS = 1;
    public Car(){
        super(REQUIRED_SPOTS);
    }
    @Override
    public boolean isCompatibleWithSpot(ParkingSpot parkingSpot) {
        return parkingSpot instanceof CarSpot || parkingSpot instanceof LargeSpot;
    }
}
