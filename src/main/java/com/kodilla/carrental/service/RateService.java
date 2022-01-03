package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Rate;
import com.kodilla.carrental.provider.RateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RateService {

    private final RateClient rateClient;

    public Rate fetchRates() {
        return rateClient.getRates();
    }


}
