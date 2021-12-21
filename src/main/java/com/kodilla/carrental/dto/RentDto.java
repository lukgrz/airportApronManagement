package com.kodilla.carrental.dto;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.domain.Client;
import com.kodilla.carrental.domain.Currency;
import com.kodilla.carrental.domain.Equipment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
public class RentDto {

    private Long id;
    private Date rentDate;
    private Date returnDate;
    private List<Equipment> equipmentList;
    private Car car;
    private Client client;
    private BigDecimal totalPrice;
    private Currency currency;
}
