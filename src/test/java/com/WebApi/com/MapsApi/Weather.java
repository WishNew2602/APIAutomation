package com.WebApi.com.MapsApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty(value = "id")
    int id;
    @JsonProperty(value = "main")
    String main;
    @JsonProperty(value = "description")
    String description;
    @JsonProperty(value = "icon")
    String icon;
}
