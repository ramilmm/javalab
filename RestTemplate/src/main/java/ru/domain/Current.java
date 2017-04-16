package ru.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {

    private Date last_updated_epoch;
    private Float temp_c;
    private Float wind_kph;
    private String wind_dir;
    private Float pressure_in;
    private Float humidity;
    private Float feelslike_c;
    private Integer cloud;

    public Date getLast_updated_epoch() {
        return last_updated_epoch;
    }

    public void setLast_updated_epoch(Date last_updated_epoch) {
        this.last_updated_epoch = new Date(last_updated_epoch.getTime()*1000);
    }

    public Float getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(Float temp_c) {
        this.temp_c = temp_c;
    }

    public Float getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(Float wind_kph) {
        this.wind_kph = wind_kph;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public Float getPressure_in() {
        return pressure_in;
    }

    public void setPressure_in(Float pressure_in) {
        this.pressure_in = pressure_in;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(Float feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public Integer getCloud() {
        return cloud;
    }

    public void setCloud(Integer cloud) {
        this.cloud = cloud;
    }

    @Override
    public String toString() {
        return "Current{" +
                "last_updated_epoch=" + last_updated_epoch +
                ", temp_c=" + temp_c +
                ", wind_kph=" + wind_kph +
                ", wind_dir='" + wind_dir + '\'' +
                ", pressure_in=" + pressure_in +
                ", humidity=" + humidity +
                ", feelslike_c=" + feelslike_c +
                ", cloud=" + cloud +
                '}';
    }
}
