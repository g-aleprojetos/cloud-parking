package com.g.aleprojetos.parking.repository;

import com.g.aleprojetos.parking.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, String> {
}
