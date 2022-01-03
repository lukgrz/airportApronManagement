package com.kodilla.carrental.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Weather {

    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("elevation")
    public double elevation;
    @JsonProperty("utc_offset_seconds")
    public int utcOffsetSeconds;
    @JsonProperty("generationtime_ms")
    public double generationTimeMs;
    @JsonProperty("longitude")
    public int longitude;
    @JsonProperty("latitude")
    public double latitude;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("current_weather")
    public CurrentWeather currentWeather;
}
