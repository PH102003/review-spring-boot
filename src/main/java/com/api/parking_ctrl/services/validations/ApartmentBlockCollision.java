package com.api.parking_ctrl.services.validations;

import com.api.parking_ctrl.dtos.ParkingSpotDto;
import com.api.parking_ctrl.repositories.ParkingSpotRepository;
import com.api.parking_ctrl.services.exceptions.BusinessValiException;

public class ApartmentBlockCollision {
    private final ParkingSpotRepository repository;
    public ApartmentBlockCollision(ParkingSpotRepository repository) {
        this.repository = repository;
    }
    public void validate (ParkingSpotDto parkingSpotDto){
        if(repository.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())){
            throw new BusinessValiException ("Conflict: Parking Spot already registered for this apartment/block!");
        }
    }    
}
