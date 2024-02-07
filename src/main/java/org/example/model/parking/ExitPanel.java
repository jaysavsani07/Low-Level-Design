package org.example.model.parking;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExitPanel {
    String id;

    public ExitPanel(String id){
        this.id = id;
    }

    public ParkingTicket scanAndVacate(ParkingTicket parkingTicket){
        ParkingSpot parkingSpot = ParkingLot.INSTANCE.vacateParkingSpot(parkingTicket.getSpotId());
        parkingTicket.setCharges(calculateCost(parkingTicket, parkingSpot.getType()));
        return parkingTicket;
    }

    double calculateCost(ParkingTicket parkingTicket, ParkingSpotType parkingSpotType){
        Duration duration = Duration.between(parkingTicket.getIssuedTime(), LocalDateTime.now());
        long hours = duration.toHours();
        if(hours ==0){
            hours = 1;
        }
        return new Cost().getCost(parkingSpotType) * hours;
    }

}
