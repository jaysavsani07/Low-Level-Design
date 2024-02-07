package org.example.model.parking;

import org.example.model.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public class EntrancePanel {
    String id;

    public EntrancePanel(String id){
        this.id = id;
    }

    public ParkingTicket generateTicket(Vehicle vehicle){
        ParkingSpot parkingSpot = ParkingLot.INSTANCE.getParkingSpot(vehicle.getType());
        if(parkingSpot == null){
            return null;
        }
        return buildTicket(vehicle , parkingSpot);
    }

    public ParkingTicket buildTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicket.setTicketNumber(UUID.randomUUID().toString());
        parkingTicket.setIssuedTime(LocalDateTime.now());
        parkingTicket.setSpotId(parkingSpot.getId());
        parkingTicket.setNumberPlate(vehicle.getLicencePlate());
        parkingTicket.setTicketStatus(TicketStatus.ACTIVE);
        return parkingTicket;
    }
}
