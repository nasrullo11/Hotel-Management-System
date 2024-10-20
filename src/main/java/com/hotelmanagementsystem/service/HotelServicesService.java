package com.hotelmanagementsystem.service;

import com.hotelmanagementsystem.dto.ServiceRequestDTO;
import com.hotelmanagementsystem.dto.ServiceResponseDTO;
import com.hotelmanagementsystem.mapper.ServiceMapper;
import com.hotelmanagementsystem.model.HotelServices;
import com.hotelmanagementsystem.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServicesService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceMapper serviceMapper;

    public ServiceResponseDTO createService(ServiceRequestDTO serviceRequestDTO) {
        HotelServices service = serviceMapper.toService(serviceRequestDTO);
        HotelServices savedService = serviceRepository.save(service);
        return serviceMapper.toServiceResponseDTO(savedService);
    }

    public ServiceResponseDTO getServiceById(Long id) {
        HotelServices service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id " + id));
        return serviceMapper.toServiceResponseDTO(service);
    }

    public List<ServiceResponseDTO> getAllServices() {
        List<HotelServices> services = serviceRepository.findAll();
        return services.stream()
                .map(serviceMapper::toServiceResponseDTO)
                .collect(Collectors.toList());
    }

    public ServiceResponseDTO updateService(Long id, ServiceRequestDTO serviceRequestDTO) {
        HotelServices service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id " + id));

        service.setServiceType(serviceRequestDTO.getServiceType());
        service.setPrice(serviceRequestDTO.getPrice());

        HotelServices updatedService = serviceRepository.save(service);
        return serviceMapper.toServiceResponseDTO(updatedService);
    }

    public void deleteService(Long id) {
        HotelServices service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id " + id));
        serviceRepository.delete(service);
    }
}
