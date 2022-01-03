package com.kodilla.carrental.service;

import com.kodilla.carrental.provider.WeatherClient;
import com.kodilla.carrental.repository.WeatherDao;
import com.kodilla.carrental.weather.Weather;
import com.sun.istack.FinalArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;
    private final WeatherDao weatherDao;

    public Weather fetchWeather () {
        Weather weather = weatherClient.getWeather();
        weatherDao.save(weather);
        return weather;
    }
}
