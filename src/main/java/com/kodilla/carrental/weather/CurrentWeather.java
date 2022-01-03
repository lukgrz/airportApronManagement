package com.kodilla.carrental.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CurrentWeather {

    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("winddirection")
    public int windDirection;
    @JsonProperty("temperature")
    public double temperature;
    @JsonProperty("weathercode")
    public int weatherCode;
    @JsonProperty("time")
    public String time;
    @JsonProperty("windspeed")
    public double windSpeed;
}
