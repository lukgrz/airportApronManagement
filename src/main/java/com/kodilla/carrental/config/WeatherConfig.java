package com.kodilla.carrental.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class WeatherConfig {
//
//    @Value("23070b1a64b391748c5da1426f580fde")
//    private String weatherApiKey;
//
//    @Value("api.openweathermap.org/data/2.5/weather")
    @Value("https://api.open-meteo.com/v1/forecast")
    private String weatherApiEndpoint;
}
