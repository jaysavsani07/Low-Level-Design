package org.example.model.parking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String street;
    private String landmark;
    private String city;
    private String state;

    public void printAddress() {
        System.out.println("=============Address of this parking lot============");
        System.out.println(street + " " + landmark + " " + city + " " + state);
    }
}
