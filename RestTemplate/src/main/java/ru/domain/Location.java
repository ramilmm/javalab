package ru.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private String name;
    private String region;
    private String country;
    private Date localtime_epoch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getLocaltime_epoch() {
        return localtime_epoch;
    }

    public void setLocaltime_epoch(Date localtime_epoch) {
        this.localtime_epoch = new Date(localtime_epoch.getTime()*1000);
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", localtime_epoch=" + localtime_epoch +
                '}';
    }
}
