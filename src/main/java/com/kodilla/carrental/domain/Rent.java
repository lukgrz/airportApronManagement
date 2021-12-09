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

    @OneToMany(
            targetEntity = Equipment.class,
            mappedBy = "equipment",
            fetch = FetchType.EAGER
    )
    private List<Equipment> equipmentList;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    private BigDecimal totalPrice;

    private Currency currency;
}
