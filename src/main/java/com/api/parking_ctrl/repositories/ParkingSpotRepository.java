package com.api.parking_ctrl.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.parking_ctrl.models.ParkingSpotModel;

@Repository
public interface ParkingSpotRepository extends JpaRepository <ParkingSpotModel, UUID> {
    
}
