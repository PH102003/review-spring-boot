package com.api.parking_ctrl.services.validations;

import com.api.parking_ctrl.dtos.ParkingSpotDto;
import com.api.parking_ctrl.repositories.ParkingSpotRepository;
import com.api.parking_ctrl.services.exceptions.BusinessValiException;

public class ParkingSpotCollision {
    private final ParkingSpotRepository repository;
    public ParkingSpotCollision(ParkingSpotRepository repository) {
        this.repository = repository;
    }
    public void validate (ParkingSpotDto parkingSpotDto){
        if(repository.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
            throw new BusinessValiException ("Conflict: Parking Spot is already in use!");
        }
    }

}
