package com.example.webapp.service;

import com.example.webapp.entity.Event;
import com.example.webapp.entity.Event.EventId;
import com.example.webapp.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Optional<Event> getEvent(EventId eventId) {
        return eventRepository.findById(eventId);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(EventId eventId) {
        eventRepository.deleteById(eventId);
    }
}
