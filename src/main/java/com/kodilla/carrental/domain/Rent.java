package com.kodilla.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "rents")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rent {

    @Id
    @GeneratedValue
    private Long id;

    private Date rentDate;

    private Date returnDate;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Equipment> equipmentList;

    @OneToOne(fetch = FetchType.EAGER)
    private Car car;

    @ManyToOne
    private Client client;

    private BigDecimal totalPrice;

    private Currency currency;
}
