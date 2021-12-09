package com.kodilla.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Invoices")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    private Rent rent;
}
