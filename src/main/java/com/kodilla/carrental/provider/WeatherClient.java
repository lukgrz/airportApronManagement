package com.kodilla.carrental.provider;

import com.kodilla.carrental.config.WeatherConfig;
import com.kodilla.carrental.weather.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class WeatherClient {

    private final RestTemplate restTemplate;
    private final WeatherConfig weatherConfig;

    public URI getWeatherUrl () {
        return UriComponentsBuilder.fromHttpUrl(weatherConfig.getWeatherApiEndpoint())
                .queryParam("latitude", 50.270908)
                .queryParam("longitude", 19.02754)
                .queryParam("current_weather", true)
                .build().encode().toUri();
    }

    public Weather getWeather() {
        URI uri = getWeatherUrl();
        Weather response = restTemplate.getForObject(uri,Weather.class);
        return response;
    }
}
