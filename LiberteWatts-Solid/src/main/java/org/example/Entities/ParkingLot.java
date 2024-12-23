package org.example.Entities;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<ParkingSpot> spots ;
    private List<List<ParkingSpot>> occupiedSpots;
    public ParkingLot(int motorcycleSpots, int carSpots, int largeSpots){
        spots = new ArrayList<>();
        occupiedSpots = new ArrayList<>();

        for(int i=0; i < motorcycleSpots;i++){
            spots.add(new MotorcycleSpot());
        }
        for(int i=0; i < carSpots;i++){
            spots.add(new CarSpot());
        }
        for(int i=0; i < largeSpots;i++){
            spots.add(new LargeSpot());
        }
    }
    public boolean parkVehicle(Vehicle vehicle) {
        List<ParkingSpot> availableSpots = findAvailableSpots(vehicle);
        if (vehicle instanceof Van) {
            for (ParkingSpot spot : availableSpots) {
                if (spot instanceof LargeSpot) {
                    spot.park();
                    occupiedSpots.add(List.of(spot));
                    return true;
                }
            }
            int consecutiveCount = 0;
            List<ParkingSpot> tempSpots = new ArrayList<>();
            for (ParkingSpot spot : availableSpots) {
                if (spot instanceof CarSpot) {
                    tempSpots.add(spot);
                    consecutiveCount++;
                    if (consecutiveCount == 3) {
                        for (ParkingSpot tempSpot : tempSpots) {
                            tempSpot.park();
                        }
                        occupiedSpots.add(tempSpots);
                        return true;
                    }
                } else {
                    tempSpots.clear();
                    consecutiveCount = 0;
                }
            }
            return false;
        }
        if (vehicle instanceof Car || vehicle instanceof Motorcycle){
            if (availableSpots.size() >= vehicle.getRequiredSpots()) {
                List<ParkingSpot> spotsToOccupy = availableSpots.subList(0, vehicle.getRequiredSpots());
                for (ParkingSpot spot : spotsToOccupy) {
                    spot.park();
                }
                occupiedSpots.add(spotsToOccupy);
                return true;
            }
        }
        return false;
    }
    public void leaveVehicle(Vehicle vehicle) {
        for (List<ParkingSpot> occupied : occupiedSpots) {
            if (occupied.size() == vehicle.getRequiredSpots() && occupied.get(0).isOccupied()) {
                for (ParkingSpot spot : occupied) {
                    spot.leave();
                }
                occupiedSpots.remove(occupied);
                break;
            }
        }
    }
    public int getRemainingSpots() {
        return (int) spots.stream().filter(spot -> !spot.isOccupied()).count();
    }
    public boolean isFull() {
        return spots.stream().allMatch(ParkingSpot::isOccupied);
    }

    public boolean isEmpty() {
        return spots.stream().noneMatch(ParkingSpot::isOccupied);
    }

    private List<ParkingSpot> findAvailableSpots(Vehicle vehicle) {
        List<ParkingSpot> availableSpots = new ArrayList<>();
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && vehicle.isCompatibleWithSpot(spot)) {
                availableSpots.add(spot);
            }
        }
        return availableSpots;
    }


}
