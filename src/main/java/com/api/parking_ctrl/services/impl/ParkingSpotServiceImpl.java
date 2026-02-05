package com.api.parking_ctrl.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.parking_ctrl.repositories.ParkingSpotRepository;
import com.api.parking_ctrl.services.ParkingSpotService;
import com.api.parking_ctrl.services.exceptions.BusinessValiException;
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
        //validar regras de negócio antes de salvar a vaga
        checkBusinessRules(parkingSpotModel);
        return parkingSpotRepository.save(parkingSpotModel);
    }
    
    private void checkBusinessRules(ParkingSpotModel model) {
        if(parkingSpotRepository.existsByLicensePlateCar(model.getLicensePlateCar())) {
            throw new BusinessValiException("Conflict: License Plate Car is already in use!");
        }
        if(parkingSpotRepository.existsByParkingSpotNumber(model.getParkingSpotNumber())) {
            throw new BusinessValiException("Conflict: Parking Spot is already in use!");
        }
        if(parkingSpotRepository.existsByApartmentAndBlock(model.getApartment(), model.getBlock())) {
            throw new BusinessValiException("Conflict: Parking Spot already registered for this apartment/block!");
        }
    }

    @Override
    public void maintenance(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maintenance'");
    }

    @Override
    public List <ParkingSpotModel> findAll() {
        return parkingSpotRepository.findAll();
    }

    @Override
    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotRepository.findById(id);    
    }
    @Transactional
    @Override
    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }
}