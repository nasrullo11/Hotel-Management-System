package com.hotelmanagementsystem.mapper;

import com.hotelmanagementsystem.dto.ServiceRequestDTO;
import com.hotelmanagementsystem.dto.ServiceResponseDTO;
import com.hotelmanagementsystem.model.HotelServices;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    ServiceRequestDTO toServiceDTO(HotelServices service);

    HotelServices toService(ServiceRequestDTO serviceRequestDTO);
    ServiceResponseDTO toServiceResponseDTO(HotelServices service);
}
