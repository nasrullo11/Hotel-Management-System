package com.hotelmanagementsystem.service;

import com.hotelmanagementsystem.dto.GuestRequestDTO;
import com.hotelmanagementsystem.dto.GuestResponseDTO;
import com.hotelmanagementsystem.mapper.GuestMapper;
import com.hotelmanagementsystem.model.Guest;
import com.hotelmanagementsystem.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private GuestMapper guestMapper;

    public GuestResponseDTO createGuest(GuestRequestDTO guestRequestDTO) {
        Guest guest = guestMapper.toGuest(guestRequestDTO);
        Guest savedGuest = guestRepository.save(guest);
        return guestMapper.toGuestResponseDTO(savedGuest);
    }

    public GuestResponseDTO getGuestById(Long id) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guest not found with id " + id));
        return guestMapper.toGuestResponseDTO(guest);
    }

    public List<GuestResponseDTO> getAllGuests() {
        List<Guest> guests = guestRepository.findAll();
        return guests.stream()
                .map(guestMapper::toGuestResponseDTO)
                .collect(Collectors.toList());
    }

    public GuestResponseDTO updateGuest(Long id, GuestRequestDTO guestRequestDTO) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guest not found with id " + id));

        guest.setFirstName(guestRequestDTO.getFirstName());
        guest.setLastName(guestRequestDTO.getLastName());
        guest.setPhone(guestRequestDTO.getPhone());
        guest.setEmail(guestRequestDTO.getEmail());
        guest.setAddress(guestRequestDTO.getAddress());

        Guest updatedGuest = guestRepository.save(guest);
        return guestMapper.toGuestResponseDTO(updatedGuest);
    }

    public void deleteGuest(Long id) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guest not found with id " + id));
        guestRepository.delete(guest);
    }
}
