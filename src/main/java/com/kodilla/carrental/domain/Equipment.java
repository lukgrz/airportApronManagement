package com.kodilla.carrental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "equipements")
public class Equipment {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private BigDecimal pricePerDay;
}
