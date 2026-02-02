package com.WebApi.com.MapsApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind{
    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    @JsonProperty(value = "speed")
    long speed;
    @JsonProperty(value = "deg")
    long deg;
}
