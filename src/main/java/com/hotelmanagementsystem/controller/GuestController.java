package com.hotelmanagementsystem.controller;

import com.hotelmanagementsystem.dto.GuestRequestDTO;
import com.hotelmanagementsystem.dto.GuestResponseDTO;
import com.hotelmanagementsystem.service.GuestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
@Tag(name = "Guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public ResponseEntity<List<GuestResponseDTO>> getAllGuests() {
        List<GuestResponseDTO> guests = guestService.getAllGuests();
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestResponseDTO> getGuestById(@PathVariable Long id) {
        GuestResponseDTO guest = guestService.getGuestById(id);
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GuestResponseDTO> createGuest(@RequestBody GuestRequestDTO guestRequestDTO) {
        GuestResponseDTO createdGuest = guestService.createGuest(guestRequestDTO);
        return new ResponseEntity<>(createdGuest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuestResponseDTO> updateGuest(@PathVariable Long id, @RequestBody GuestRequestDTO guestRequestDTO) {
        GuestResponseDTO updatedGuest = guestService.updateGuest(id, guestRequestDTO);
        return new ResponseEntity<>(updatedGuest, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
