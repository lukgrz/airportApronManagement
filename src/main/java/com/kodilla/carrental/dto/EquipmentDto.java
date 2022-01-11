package com.kodilla.carrental.dto;

import com.kodilla.carrental.domain.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class EquipmentDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal pricePerDay;
}
