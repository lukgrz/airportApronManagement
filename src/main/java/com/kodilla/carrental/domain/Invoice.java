package com.kodilla.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "Invoices")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(targetEntity = Rent.class)
    private Rent rent;
}
