package com.hotelmanagementsystem.service;

import com.hotelmanagementsystem.dto.RoomRequestDTO;
import com.hotelmanagementsystem.dto.RoomResponseDTO;
import com.hotelmanagementsystem.mapper.RoomMapper;
import com.hotelmanagementsystem.model.Hotel;
import com.hotelmanagementsystem.model.Room;
import com.hotelmanagementsystem.repository.HotelRepository;
import com.hotelmanagementsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public RoomResponseDTO createRoom(RoomRequestDTO roomRequestDTO) {
        Hotel hotel = hotelRepository.findById(roomRequestDTO.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found with id " + roomRequestDTO.getHotelId()));

        Room room = new Room();
        room.setHotel(hotel);
        room.setRoomNumber(roomRequestDTO.getRoomNumber());
        room.setRoomType(roomRequestDTO.getRoomType());
        room.setPrice(roomRequestDTO.getPrice());
        room.setStatus(roomRequestDTO.getStatus());

        Room savedRoom = roomRepository.save(room);

        return RoomMapper.convertToResponseDTO(savedRoom);
    }


    public RoomResponseDTO getRoomById(Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id " + roomId));

        return RoomMapper.convertToResponseDTO(room);
    }


    public List<RoomResponseDTO> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                .map(RoomMapper::convertToResponseDTO)
                .collect(Collectors.toList());
    }



    public RoomResponseDTO updateRoom(Long id, RoomRequestDTO roomRequestDTO) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id " + id));

        Hotel hotel = hotelRepository.findById(roomRequestDTO.getHotelId()).orElseThrow(
                () -> new RuntimeException("Hotel not found with id " + roomRequestDTO.getHotelId())
        );
        room.setHotel(hotel);
        room.setRoomNumber(roomRequestDTO.getRoomNumber());
        room.setRoomType(roomRequestDTO.getRoomType());
        room.setPrice(roomRequestDTO.getPrice());
        room.setStatus(roomRequestDTO.getStatus());

        Room updatedRoom = roomRepository.save(room);
        return RoomMapper.convertToResponseDTO(updatedRoom);
    }

    public void deleteRoom(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id " + id));
        roomRepository.delete(room);
    }
}
