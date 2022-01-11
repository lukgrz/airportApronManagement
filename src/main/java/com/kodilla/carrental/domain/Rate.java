package com.kodilla.carrental.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rate {

    @JsonProperty("PLN_EUR")
    public double pln_Eur;

    @JsonProperty("PLN_USD")
    public double pln_Usd;
}
