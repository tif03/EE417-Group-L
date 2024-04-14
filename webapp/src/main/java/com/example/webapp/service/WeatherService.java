package com.example.webapp.service;

import com.example.webapp.entity.Weather;
import com.example.webapp.repository.WeatherRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }
    
    

    public Weather getWeatherByDate(Date date) {
        return weatherRepository.findById(date).orElse(null);
    }

    public List<Weather> getAllWeather() {
        return weatherRepository.findAll();
    }

    public Weather saveWeather(Weather weather) {
        return weatherRepository.save(weather);
    }
    
    public Weather getLatestWeather() {
    	Weather weather = weatherRepository.findTopByOrderByDayDesc();
        if (weather != null && weather.getWindSpeed() == null) {
            weather.setWindSpeed(0.0);  // Default to 0.0 if null
        }
        return weather;
    }
}
