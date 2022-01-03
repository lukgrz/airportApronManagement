package com.kodilla.carrental.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class RateConfig {

    @Value("https://free.currconv.com/")
    private String rateApiEndpoint;

    @Value("ed67dd71fdc4696e2e8e")
    private String rateKey;
}
