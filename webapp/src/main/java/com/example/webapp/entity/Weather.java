package com.example.webapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "Weather")
public class Weather {

    @Id
    @Column(name = "Day")
    private Date day;

    @Column(name = "Value")
    private String value;

    @Column(name = "Temp")
    private Double temp;

    @Column(name = "WindSpeed")
    private Double windSpeed;

    @Column(name = "Humidity")
    private Integer humidity;

    public Weather() {
    }

    // Getters
    public Date getDay() {
        return day;
    }

    public String getValue() {
        return value;
    }

    public double getTemp() {
        return temp;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public int getHumidity() {
        return humidity;
    }

    // Setters
    public void setDay(Date day) {
        this.day = day;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}