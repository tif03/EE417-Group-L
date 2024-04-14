package com.example.webapp.service;

import com.example.webapp.entity.Room;
import com.example.webapp.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room getRoomByNumber(int roomNumber) {
        return roomRepository.findById(roomNumber).orElse(null);
    }

    public List<Room> getAllRooms() {
    	List<Room> rooms = roomRepository.findAll();
        rooms.forEach(room -> {
            if (room.getOccupiedSeat() == null) {
                room.setOccupiedSeat(0); // Default to 0 if null
            }
        });
        return rooms;
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(int roomNumber) {
        roomRepository.deleteById(roomNumber);
    }
}
