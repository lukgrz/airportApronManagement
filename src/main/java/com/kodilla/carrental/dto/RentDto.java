package com.kodilla.carrental.dto;

import com.kodilla.carrental.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

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
    private Price totalPrice;
}
