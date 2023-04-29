package com.g.aleprojetos.parking.service;

import com.g.aleprojetos.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ParkingService {
    private static final Map<String, Parking> parkingMap = new HashMap<>();


    static {
        var id = getUUID();
        var id1 = getUUID();
        Parking parking = new Parking(id, "DMS-1111", "SC", "Celta", "Preto");
        Parking parking1 = new Parking(id1, "WAS1234", "SP", "VW Gol", "Vermelho");
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking1);
    }

    public List<Parking> findAll(){

        return new ArrayList<>(parkingMap.values());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }
}
