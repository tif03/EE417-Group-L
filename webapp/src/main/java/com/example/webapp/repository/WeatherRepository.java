package com.example.webapp.repository;

import com.example.webapp.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;

public interface WeatherRepository extends JpaRepository<Weather, Date> {
	 Weather findTopByOrderByDayDesc();

}
