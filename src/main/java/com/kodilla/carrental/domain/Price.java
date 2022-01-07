package com.kodilla.carrental.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Price {

    @Id
    @GeneratedValue
    private Long id;
    private Currency currency = Currency.PLN;
    private BigDecimal priceInPln;
    private BigDecimal priceInCurrency;
    private LocalDate localDate;

    public Price(BigDecimal priceInPln) {
        this.priceInPln = priceInPln;
    }

    public void calculatePriceInCurrency(Rate rate) {
        switch (currency) {
            case EUR:
                priceInCurrency = priceInPln.multiply(BigDecimal.valueOf(rate.getPln_Eur()));
                break;
            case USD:
                priceInCurrency = priceInPln.multiply(BigDecimal.valueOf(rate.getPln_Usd()));
                break;
            case PLN:
                priceInCurrency = priceInPln;
        }
    }
}
