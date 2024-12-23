package org.example.Entities;

abstract class ParkingSpot {
    private boolean isOccupied ;

    public ParkingSpot(){
        this.isOccupied=false;
    }
    public boolean isOccupied(){
        return isOccupied;
    }
    //marque la place comme occupied
    public void park(){
        this.isOccupied=true;
    }
    //libere la place
    public void leave(){
        this.isOccupied=false;
    }
    public abstract boolean isVehicleCompatible(Vehicle vehicle);
}
