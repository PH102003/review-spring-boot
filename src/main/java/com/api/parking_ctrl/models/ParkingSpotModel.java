package com.api.parking_ctrl.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


import org.springframework.aot.generate.GenerationContext;
import org.springframework.stereotype.Indexed;


@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;
    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;
    @Column(nullable = false, length = 70, unique = false)
    private String brandCar;
    @Column(nullable = false, length = 70, unique = false)
    private String modelCar;                  
    @Column(nullable = false, length = 70, unique = false)
    private String colorCar;
    @Column(nullable = false, length = 0, unique = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false, length = 130, unique = false)
    private String responsibleName;
    @Column(nullable = false, length = 30, unique = false)
    private String apartment;
    @Column(nullable = false, length = 30, unique = false)
    private String block;  
}
