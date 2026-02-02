package com.WebApi.com.MapsApi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationVariable {

    String path;
    private static final Properties config = new Properties();

    public ConfigurationVariable(String path){
        this.path = path;
        try(InputStream in = ConfigurationVariable.class.getClassLoader().getResourceAsStream(path)){
            if(in != null){
                config.load(in);
            }else {
                config.load(ConfigurationVariable.class.getClassLoader().getResourceAsStream("config.properties"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public String getProperty(String key){
        return config.getProperty(key);
    }

}
