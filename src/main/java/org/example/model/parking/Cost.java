package org.example.model.parking;

import org.example.model.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class Cost {
    Map<ParkingSpotType, Double> hourlyCost = new HashMap<>();

    public Cost(){
        hourlyCost.put(ParkingSpotType.COMPACT, 20.0);
        hourlyCost.put(ParkingSpotType.LARGE, 30.0);
        hourlyCost.put(ParkingSpotType.TRUCK, 40.0);
        hourlyCost.put(ParkingSpotType.ELECTRIC, 25.0);

    }

    double getCost(ParkingSpotType spotType){
        return hourlyCost.get(spotType);
    }

}
