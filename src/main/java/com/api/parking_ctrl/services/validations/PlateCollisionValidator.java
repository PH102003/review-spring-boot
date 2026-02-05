package com.api.parking_ctrl.services.validations;

import com.api.parking_ctrl.dtos.ParkingSpotDto;
import com.api.parking_ctrl.repositories.ParkingSpotRepository;
import com.api.parking_ctrl.services.exceptions.BusinessValiException;

import org.springframework.stereotype.Component;

@Component
public class PlateCollisionValidator {

    private final ParkingSpotRepository repository;

    public PlateCollisionValidator(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    public void validate(ParkingSpotDto dto) {
        if (repository.existsByLicensePlateCar(dto.getLicensePlateCar())) {
            throw new BusinessValiException ("Conflict: License Plate Car is already in use!");
        }
    }
}