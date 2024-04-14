package com.example.webapp.repository;

import com.example.webapp.entity.Event;
import com.example.webapp.entity.Event.EventId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, EventId> {
    // You can add queries specific to events, such as findByDate or findByEventName
}
