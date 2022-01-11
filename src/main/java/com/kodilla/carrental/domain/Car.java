package com.kodilla.carrental.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private String registration;
    private String engineCapacity;
    private int seatsNumber;
    private int doorsNumber;
    private Gearbox gearbox;
    private BigDecimal startingPrice;
    private BigDecimal pricePerDay;

    public Car(String brand, String model, String registration, String engineCapacity, int seatsNumber, int doorsNumber,
               Gearbox gearbox, BigDecimal startingPrice, BigDecimal pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.registration = registration;
        this.engineCapacity = engineCapacity;
        this.seatsNumber = seatsNumber;
        this.doorsNumber = doorsNumber;
        this.gearbox = gearbox;
        this.startingPrice = startingPrice;
        this.pricePerDay = pricePerDay;
    }
}
