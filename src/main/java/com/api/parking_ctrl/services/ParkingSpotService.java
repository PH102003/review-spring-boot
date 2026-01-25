package com.api.parking_ctrl.services;

import org.springframework.stereotype.Service;

import com.api.parking_ctrl.models.ParkingSpotModel;
import com.api.parking_ctrl.repositories.ParkingSpotRepository;

public interface ParkingSpotService {
// método que lida com manuntenções que possam impossibilitar uso do estacionamento
    void maintenance(Long id);
// 'motor' que empurra o dado para dentro do banco de dados (lida com criação de vagas e alterações na vaga)
    ParkingSpotModel save(ParkingSpotModel parkingSpotModel);

}
