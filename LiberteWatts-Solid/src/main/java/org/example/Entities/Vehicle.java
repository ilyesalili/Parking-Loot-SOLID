package org.example.Entities;

public abstract class Vehicle {
    private final int requiredSpots;
    public Vehicle(int requiredSpots) {
        this.requiredSpots = requiredSpots;
    }
    // retourne le nombre de Spots nécessaires
    public int getRequiredSpots(){
          return requiredSpots;
    }
    public abstract boolean isCompatibleWithSpot(ParkingSpot parkingSpot);
}
