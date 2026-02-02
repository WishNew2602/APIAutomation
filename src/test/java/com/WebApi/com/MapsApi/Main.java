package com.WebApi.com.MapsApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main{
    public int getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(int grnd_level) {
        this.grnd_level = grnd_level;
    }

    public int getSea_level() {
        return sea_level;
    }

    public void setSea_level(int sea_level) {
        this.sea_level = sea_level;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public long getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(long temp_max) {
        this.temp_max = temp_max;
    }

    public long getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(long temp_min) {
        this.temp_min = temp_min;
    }

    public long getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(long feels_like) {
        this.feels_like = feels_like;
    }

    public long getTemp() {
        return temp;
    }

    public void setTemp(long temp) {
        this.temp = temp;
    }

    @JsonProperty(value = "temp")
    long temp;
    @JsonProperty(value = "feels_like")
    long feels_like;
    @JsonProperty(value = "temp_min")
    long temp_min;
    @JsonProperty(value = "temp_max")
    long temp_max;
    @JsonProperty(value = "pressure")
    int pressure;
    @JsonProperty(value = "humidity")
    int humidity;
    @JsonProperty(value = "sea_level")
    int sea_level;
    @JsonProperty(value = "grnd_level")
    int grnd_level;
}
