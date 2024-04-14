package com.example.webapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @Column(name = "RoomNumber")
    private Integer roomNumber;

    @Column(name = "Available")
    private Boolean available;

    @Column(name = "Location")
    private String location;

    @Column(name = "Capacity")
    private Integer capacity;

    @Column(name = "OccupiedSeat")
    private Integer occupiedSeat;

    public Room() {
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public Integer getOccupiedSeat() {
        return occupiedSeat;
    }

    // Setters
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setOccupiedSeat(int occupiedSeat) {
        this.occupiedSeat = occupiedSeat;
    }
}