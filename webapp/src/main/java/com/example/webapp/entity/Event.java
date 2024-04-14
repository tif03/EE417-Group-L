package com.example.webapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Event")
public class Event {

    @EmbeddedId
    private EventId id;

    public Event() {
    }

    // Getter and Setter for id
    public EventId getId() {
        return id;
    }

    public void setId(EventId id) {
        this.id = id;
    }

 // EmbeddedId class to hold composite key
    @Embeddable
    public static class EventId implements Serializable {
        @Column(name = "EventName")
        private String eventName;

        @Column(name = "Date")
        private Date date;

        @Column(name = "Time")
        private Date time; // Time is managed as Date to include time aspects

        // Parameterized constructor
        public EventId(String eventName, Date date, Date time) {
            this.eventName = eventName;
            this.date = date;
            this.time = time;
        }
        public EventId() {
        }

        // Getters and Setters
        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((date == null) ? 0 : date.hashCode());
            result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
            result = prime * result + ((time == null) ? 0 : time.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            EventId other = (EventId) obj;
            if (date == null) {
                if (other.date != null)
                    return false;
            } else if (!date.equals(other.date))
                return false;
            if (eventName == null) {
                if (other.eventName != null)
                    return false;
            } else if (!eventName.equals(other.eventName))
                return false;
            if (time == null) {
                if (other.time != null)
                    return false;
            } else if (!time.equals(other.time))
                return false;
            return true;
        }
    }
}

