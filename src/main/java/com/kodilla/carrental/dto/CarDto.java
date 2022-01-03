package com.kodilla.carrental.dto;

import com.kodilla.carrental.domain.Gearbox;
import com.kodilla.carrental.domain.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private String registration;
    private String engineCapacity;
    private int seatsNumber;
    private int doorsNumber;
    private Gearbox gearbox;
    private Price startingPrice;
    private Price pricePerDay;
}
