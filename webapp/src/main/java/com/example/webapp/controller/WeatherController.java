package com.example.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.webapp.entity.Weather;
import com.example.webapp.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Get the most recent weather data
    @GetMapping("/today")
    public ResponseEntity<Weather> getTodayWeather() {
        Weather weather = weatherService.getLatestWeather();
        if (weather != null) {
            return new ResponseEntity<>(weather, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all weather entries
    @GetMapping("/all")
    public ResponseEntity<List<Weather>> getAllWeather() {
        List<Weather> weathers = weatherService.getAllWeather();
        if (weathers != null && !weathers.isEmpty()) {
            return new ResponseEntity<>(weathers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // Add a new weather entry
    @PostMapping("/add")
    public ResponseEntity<Weather> addWeather(@RequestBody Weather weather) {
        Weather savedWeather = weatherService.saveWeather(weather);
        return new ResponseEntity<>(savedWeather, HttpStatus.CREATED);
    }
}
