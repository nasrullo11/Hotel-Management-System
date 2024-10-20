package com.hotelmanagementsystem.controller;

import com.hotelmanagementsystem.dto.ServiceRequestDTO;
import com.hotelmanagementsystem.dto.ServiceResponseDTO;
import com.hotelmanagementsystem.service.HotelServicesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@Tag(name = "Service")
public class ServiceController {

    @Autowired
    private HotelServicesService serviceService;

    @PostMapping
    public ResponseEntity<ServiceResponseDTO> createService(@RequestBody ServiceRequestDTO serviceRequestDTO) {
        ServiceResponseDTO createdService = serviceService.createService(serviceRequestDTO);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponseDTO> getServiceById(@PathVariable Long id) {
        ServiceResponseDTO service = serviceService.getServiceById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ServiceResponseDTO>> getAllServices() {
        List<ServiceResponseDTO> services = serviceService.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceResponseDTO> updateService(
            @PathVariable Long id, @RequestBody ServiceRequestDTO serviceRequestDTO) {
        ServiceResponseDTO updatedService = serviceService.updateService(id, serviceRequestDTO);
        return new ResponseEntity<>(updatedService, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
