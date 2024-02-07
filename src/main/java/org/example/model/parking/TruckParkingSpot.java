package org.example.model.parking;

public class TruckParkingSpot extends ParkingSpot{
    public TruckParkingSpot(String id) {
        super(id, ParkingSpotType.TRUCK);
    }
}
