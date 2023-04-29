package com.g.aleprojetos.parking.service;

import com.g.aleprojetos.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParkingService {
    private static final Map<String, Parking> parkingMap = new HashMap<>();


    static {
        var id = getUUID();
        Parking parking = new Parking(id, "DMS-1111", "SC", "CELTA", "PRETO");
        parkingMap.put(id, parking);
    }

    public List<Parking> findAll(){

        return new ArrayList<>(parkingMap.values());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
