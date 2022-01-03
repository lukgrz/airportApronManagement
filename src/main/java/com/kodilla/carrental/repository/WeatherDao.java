package com.kodilla.carrental.repository;

import com.kodilla.carrental.weather.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherDao extends CrudRepository<Weather, Long> {

    @Override
    Weather save(Weather weather);

}
