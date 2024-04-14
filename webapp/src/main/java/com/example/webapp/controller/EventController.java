package com.example.webapp.controller;

import com.example.webapp.entity.Event;
import com.example.webapp.entity.Event.EventId;
import com.example.webapp.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{eventName}/{date}/{time}")
    public ResponseEntity<Event> getEvent(@PathVariable String eventName, @PathVariable String date, @PathVariable String time) {
        EventId eventId = new EventId(eventName, java.sql.Date.valueOf(date), java.sql.Time.valueOf(time));
        Optional<Event> event = eventService.getEvent(eventId);
        return event.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        if (!events.isEmpty()) {
            return new ResponseEntity<>(events, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event newEvent = eventService.saveEvent(event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{eventName}/{date}/{time}")
    public ResponseEntity<Void> deleteEvent(@PathVariable String eventName, @PathVariable String date, @PathVariable String time) {
        EventId eventId = new EventId(eventName, java.sql.Date.valueOf(date), java.sql.Time.valueOf(time));
        if (eventService.getEvent(eventId).isPresent()) {
            eventService.deleteEvent(eventId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
