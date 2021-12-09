package com.kodilla.carrental.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Equipment {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private BigDecimal pricePerDay;

    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "rent_id")
    private Rent rent;
}
