package com.kodilla.carrental.dto;

import com.kodilla.carrental.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {

    private Long id;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private List<Equipment> equipmentList;
    private Car car;
    private Client client;
    private Currency currency;
    private BigDecimal totalPrice;
}
