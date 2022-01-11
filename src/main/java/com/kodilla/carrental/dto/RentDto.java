package com.kodilla.carrental.dto;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.domain.Client;
import com.kodilla.carrental.domain.Equipment;
import com.kodilla.carrental.domain.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class RentDto {

    private Long id;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private List<Equipment> equipmentList;
    private Car car;
    private Client client;
    private Price totalPrice;
}
