package com.api.parking_ctrl.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.parking_ctrl.repositories.ParkingSpotRepository;
import com.api.parking_ctrl.services.ParkingSpotService;
import com.api.parking_ctrl.models.ParkingSpotModel;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

    // Injeção de dependência do repository
    private final ParkingSpotRepository parkingSpotRepository;

    //Spring entende que precisa passar o repository aqui
    public ParkingSpotServiceImpl(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Override
    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    @Override
    public void maintenance(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maintenance'");
    }
}