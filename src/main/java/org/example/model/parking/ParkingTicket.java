package org.example.model.parking;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ParkingTicket {
    private String ticketNumber;
    private LocalDateTime issuedTime;
    private LocalDateTime vacateTime;
    private String spotId;
    private String numberPlate;
    private Double charges;
    private TicketStatus ticketStatus;

    public void printParkingTicket(){
        System.out.println("========ticket===========");
        System.out.println("Vehicle " + numberPlate + "  on Spot " + spotId);
        System.out.println("at time " + issuedTime);;
    }
}
