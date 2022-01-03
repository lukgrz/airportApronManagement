package com.kodilla.carrental.weather;

import com.kodilla.carrental.service.WeatherService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Scheduler {

    private final WeatherService weatherService;

    @Scheduled(initialDelay = 5000, fixedDelay = 30*60*1000)
    public void getActualWeather() {
        weatherService.fetchWeather();
    }
}
