package org.example.model.vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
    String licencePlate;
    VehicleType type;

    Vehicle(String licencePlate, VehicleType type){
        this.licencePlate = licencePlate;
        this.type = type;
    }
}
