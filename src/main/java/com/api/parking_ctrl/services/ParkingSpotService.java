package com.api.parking_ctrl.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.api.parking_ctrl.models.ParkingSpotModel;

public interface ParkingSpotService {
// método que lida com manuntenções que possam impossibilitar uso do estacionamento
    void maintenance(Long id);
// 'motor' que empurra o dado para dentro do banco de dados (lida com criação de vagas e alterações na vaga)
    ParkingSpotModel save(ParkingSpotModel parkingSpotModel);
    Page<ParkingSpotModel> findAll(Pageable pageable);
    Optional<ParkingSpotModel> findById(UUID id);
    void delete(ParkingSpotModel parkingSpotModel);




}
