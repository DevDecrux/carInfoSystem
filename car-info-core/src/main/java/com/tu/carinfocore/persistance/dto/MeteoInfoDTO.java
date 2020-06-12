package com.tu.carinfocore.persistance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeteoInfoDTO {

    @JsonProperty(value = "Temp")
    private String temperature;
    @JsonProperty(value = "Humidity")
    private String humidity;
    @JsonProperty(value = "eCO2")
    private String eco2;
    @JsonProperty(value = "TVOC")
    private String tvoc;
    @JsonProperty(value = "Date")
    private String date;
    @JsonProperty(value = "Hours")
    private String hours;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getEco2() {
        return eco2;
    }

    public void setEco2(String eco2) {
        this.eco2 = eco2;
    }

    public String getTvoc() {
        return tvoc;
    }

    public void setTvoc(String tvoc) {
        this.tvoc = tvoc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
