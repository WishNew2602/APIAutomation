package com.WebApi.com.MapsApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coord{
    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    @JsonProperty(value = "lon")
    double lon;
    @JsonProperty(value = "lat")
    double lat;
}
