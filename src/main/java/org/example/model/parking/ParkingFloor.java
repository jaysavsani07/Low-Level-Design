package org.example.model.parking;

import lombok.Getter;
import lombok.Setter;
import org.example.common.Constants;
import org.example.model.vehicle.Vehicle;
import org.example.model.vehicle.VehicleType;

import java.util.*;

import static org.example.model.parking.ParkingSpotType.*;

public class ParkingFloor{
    @Setter
    @Getter
    String floorId;
    @Getter
    Map<ParkingSpotType, Queue<ParkingSpot>> parkingSpots = new HashMap<>();
    Map<String, ParkingSpot> usedSpots = new HashMap<>();
    int capacityUsed = 0;

    public ParkingFloor(String id){
        this.floorId = id;
        parkingSpots.put(COMPACT, new LinkedList<>());
        parkingSpots.put(ELECTRIC, new LinkedList<>());
        parkingSpots.put(LARGE, new LinkedList<>());
        parkingSpots.put(TRUCK, new LinkedList<>());
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        for(Queue<ParkingSpot> queue: parkingSpots.values()){
            for(ParkingSpot spot: queue){
                if(spot.getId().equals(parkingSpot.getId())){
                    System.out.println("????? " + parkingSpot.getId()+ " already exist ?????");
                    return;
                }
            }
        }
        if(capacityUsed >= Constants.MAX_CAPACITY_FLOOR){
            System.out.println("Maximum parking spot capacity for this floor reached");
            return;
        }
        parkingSpots.get(parkingSpot.getType()).add(parkingSpot);
        capacityUsed++;
        System.out.println("Parking spot " + parkingSpot.getId() + " added successfully");
    }

    boolean canPark(VehicleType vehicleType){
        return !parkingSpots.get(getSpotTypeForVehicle(vehicleType)).isEmpty();
    }

    boolean isFloorFull(){
        for (Queue<ParkingSpot> spot: parkingSpots.values()) {
            if(!spot.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public void updateDisplayBoard(){
        int totalSpots=0;
        int available=0;
        int used = 0;
        for(Queue<ParkingSpot> spots: parkingSpots.values()){
            totalSpots += spots.size();
        }
        used = usedSpots.size();
        System.out.println("-------- Display Board -----------");
        System.out.println(" available " + (totalSpots-used));
        System.out.println(" used " + used);
    }

    public ParkingSpotType getSpotTypeForVehicle(VehicleType vehicleType) {
        return switch (vehicleType) {
            case ELECTRICCAR -> ELECTRIC;
            case VAN -> LARGE;
            case TRUCK -> TRUCK;
            default -> COMPACT;
        };
    }

    public ParkingSpot vacateSpot(String spotId){
        ParkingSpot parkingSpot = usedSpots.remove(spotId);
        if(parkingSpot != null){
            parkingSpots.get(parkingSpot.getType()).add(parkingSpot);
        }
        return parkingSpot;
    }

    ParkingSpot assignVehicleToSpot(VehicleType vehicleType){
        if(canPark(vehicleType)){
            ParkingSpot parkingSpot = parkingSpots.get(getSpotTypeForVehicle(vehicleType)).poll();
            assert parkingSpot != null;
            usedSpots.put(parkingSpot.getId(), parkingSpot);
            return parkingSpot;
        }else{
            System.out.println("Sorry can't park");
            // better way for error handling which says can't park on this floor instead null
            return null;
        }
    }

}
