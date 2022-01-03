package com.kodilla.carrental.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

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
    @JsonProperty("current_weather")
    public CurrentWeather currentWeather;
}
