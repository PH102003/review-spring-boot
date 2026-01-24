package com.api.parking_ctrl.services.impl;

import org.springframework.stereotype.Service;
import com.api.parking_ctrl.repositories.ParkingSpotRepository;
import com.api.parking_ctrl.services.ParkingSpotService;
import com.api.parking_ctrl.models.ParkingSpotModel;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

    // Aqui está o segredo: injetamos o REPOSITORY, não o SERVICE
    private final ParkingSpotRepository parkingSpotRepository;

    // Construtor: O Spring entende que precisa passar o repository aqui
    public ParkingSpotServiceImpl(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Override
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }
}