package com.WebApi.com.MapsApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherAPI {

    @JsonProperty(value = "coord")
    Coord coord;
    @JsonProperty(value = "weather")
    Weather[] weather;
    @JsonProperty(value = "base")
    String base;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @JsonProperty(value = "main")
    Main main;
    @JsonProperty(value = "visibility")
    String visibility;
    @JsonProperty(value = "wind")
    Wind wind;
    @JsonProperty(value = "clouds")
    Clouds clouds;
    @JsonProperty(value = "dt")
    long dt;
    @JsonProperty(value = "sys")
    Sys sys;
    @JsonProperty(value = "time")
    double time;
    @JsonProperty(value="timezone")
    String timezone;
    @JsonProperty(value = "id")
    long id;
    @JsonProperty(value = "name")
    String name;
    @JsonProperty(value = "cod")
    int cod;
}


//{
//        "coord": {
//        "lon": 78.4744,
//        "lat": 17.3753
//        },
//        "weather": [
//        {
//        "id": 721,
//        "main": "Haze",
//        "description": "haze",
//        "icon": "50d"
//        }
//        ],
//        "base": "stations",
//        "main": {
//        "temp": 300.38,
//        "feels_like": 300.13,
//        "temp_min": 300.38,
//        "temp_max": 300.88,
//        "pressure": 1014,
//        "humidity": 39,
//        "sea_level": 1014,
//        "grnd_level": 951
//        },
//        "visibility": 5000,
//        "wind": {
//        "speed": 5.14,
//        "deg": 90
//        },
//        "clouds": {
//        "all": 40
//        },
//        "dt": 1769772422,
//        "sys": {
//        "type": 1,
//        "id": 9214,
//        "country": "IN",
//        "sunrise": 1769735913,
//        "sunset": 1769776796
//        },
//        "timezone": 19800,
//        "id": 1269843,
//        "name": "Hyderabad",
//        "cod": 200
//        }