package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final RateService rateService;

    public Price getPrice(Price price) {
        price.calculatePriceInCurrency(rateService.fetchRates());
        return price;
    }
}
