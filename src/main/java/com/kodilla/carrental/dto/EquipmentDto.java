package com.kodilla.carrental.dto;

import com.kodilla.carrental.domain.Rent;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class EquipmentDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal pricePerDay;
    private boolean isAvailable;
    private Rent rent;
}
