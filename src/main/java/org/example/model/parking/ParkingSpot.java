package org.example.model.parking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ParkingSpot {
    private String id;
    private ParkingSpotType type;
    private Boolean isAvailable;
    private String assignedVehicleId;

    public ParkingSpot(String id, ParkingSpotType type){
        this.id = id;
        this.type = type;
    }

    public void assignCar(String vehicleId){
        this.isAvailable = false;
        this.assignedVehicleId = vehicleId;
    }
    // how to handle un-assign car
    // by having method un-assign car we can have a method isFree()
    // which can help us to detect if spot is free or not

}
