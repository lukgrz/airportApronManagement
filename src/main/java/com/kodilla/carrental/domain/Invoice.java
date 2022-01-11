package com.kodilla.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Invoices")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    private String number;
    private LocalDate dateOfIssue;

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    private Rent rent;

    public Invoice(String number, LocalDate dateOfIssue, Rent rent) {
        this.number = number;
        this.dateOfIssue = dateOfIssue;
        this.rent = rent;
    }
}
