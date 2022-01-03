package com.kodilla.carrental.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class CurrentWeather {

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
