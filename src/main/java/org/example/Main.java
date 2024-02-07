package org.example;


import org.example.model.parking.*;
import org.example.model.vehicle.ElectricCar;
import org.example.model.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Hello world!");
        ParkingLot parkingLot = ParkingLot.INSTANCE;
//        Address address = new Address();
//        address.setStreet("Bikers street");
//        address.setLandmark("Mango Circle");
//        address.setCity("Gandhinagar");
//        address.setState("Gujarat");
//        parkingLot.setAddress(address);
        parkingLot.printAddress();

        ParkingFloor floor1 = new ParkingFloor("floor_1");
        ParkingSpot spot1 = new ElectricParkingSpot("f1_e1");

        ParkingSpot spot2 = new CompactParkingSpot("f1_c1");
        ParkingSpot spot3 = new LargeParkingSpot("f1_l1");
        ParkingSpot spot4 = new TruckParkingSpot("f1_t1");

        ParkingSpot spot5 = new ElectricParkingSpot("f1_e2");
        ParkingSpot spot6 = new ElectricParkingSpot("f1_e3");
        ParkingSpot spot7 = new ElectricParkingSpot("f1_e4");
        ParkingSpot spot8 = new CompactParkingSpot("f1_c2");
        ParkingSpot spot9 = new CompactParkingSpot("f1_c3");
        ParkingSpot spot10 = new LargeParkingSpot("f1_l2");
        ParkingSpot spot11 = new TruckParkingSpot("f1_t2");

        floor1.addParkingSpot(spot1);
        floor1.addParkingSpot(spot2);
        floor1.addParkingSpot(spot3);
        floor1.addParkingSpot(spot4);
        floor1.addParkingSpot(spot5);
        floor1.addParkingSpot(spot6);
        floor1.addParkingSpot(spot7);
        floor1.addParkingSpot(spot8);
        floor1.addParkingSpot(spot9);
        floor1.addParkingSpot(spot10);
        floor1.addParkingSpot(spot11);


        parkingLot.addParkingFloor(floor1);
        ParkingFloor floor2 = new ParkingFloor("floor_2");
        parkingLot.addParkingFloor(floor2);

        EntrancePanel entrancePanel = new EntrancePanel("entry_panel_1");
        Vehicle vehicle = new ElectricCar("EV00001");
        ParkingTicket ticket1 = entrancePanel.generateTicket(vehicle);
        ticket1.printParkingTicket();

        ExitPanel exitPanel = new ExitPanel("exit_pane_1");
        exitPanel.scanAndVacate(ticket1);

        parkingLot.addParkingFloor(new ParkingFloor("floor_1"));

    }
}