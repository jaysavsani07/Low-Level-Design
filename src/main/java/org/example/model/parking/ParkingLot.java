package org.example.model.parking;

import lombok.Getter;
import lombok.Setter;
import org.example.model.vehicle.VehicleType;

import java.util.*;

@Getter
@Setter

public class ParkingLot {
    String parkingLotId;
    Map<String, ParkingFloor> parkingFloorsMap;
    List<EntrancePanel> entrancePanels;
    List<ExitPanel> exitPanels;
    Address address;
    public static ParkingLot INSTANCE = new ParkingLot();

    private ParkingLot() {
        this.parkingLotId = UUID.randomUUID().toString();
        parkingFloorsMap = new HashMap<>();
        entrancePanels = new ArrayList<>();
        exitPanels = new ArrayList<>();
    }

    public void addParkingFloor(ParkingFloor parkingFloor){
        if(parkingFloorsMap.containsKey(parkingFloor.getFloorId())){
            System.out.println("Parking floor with id " + parkingFloor.getFloorId()+ " already exist!!!");
        }else{
            parkingFloorsMap.put(parkingFloor.floorId, parkingFloor);
            System.out.println("Parking floor " + parkingFloor.getFloorId()+  " added successfully");
        }
    }

    ParkingSpot getParkingSpot(VehicleType vehicleType){
        for(ParkingFloor parkingFloor : ParkingLot.INSTANCE.getParkingFloorsMap().values()){
            ParkingSpot parkingSpot = parkingFloor.assignVehicleToSpot(vehicleType);
            if(parkingSpot != null){
                return parkingSpot;
            }
        }
        return null;
    }

    ParkingSpot vacateParkingSpot(String spotId){
        for(ParkingFloor parkingFloor : ParkingLot.INSTANCE.getParkingFloorsMap().values()){
            ParkingSpot parkingSpot = parkingFloor.vacateSpot(spotId);
            if(parkingSpot != null){
                return parkingSpot;
            }
        }
        return null;
    }

    public void printAddress(){
        if(address != null){
            address.printAddress();
        }
    }
}
