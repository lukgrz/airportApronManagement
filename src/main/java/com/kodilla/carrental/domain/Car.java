package com.kodilla.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String brand;

    private String model;

    private String registration;

    private String engineCapacity;

    private int seatsNumber;

    private int doorsNumber;

    private Gearbox gearbox;

    @OneToOne
    private Price startingPrice;

    @OneToOne
    private Price pricePerDay;
}
