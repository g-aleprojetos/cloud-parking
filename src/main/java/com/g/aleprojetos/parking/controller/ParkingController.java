package com.g.aleprojetos.parking.controller;

import com.g.aleprojetos.parking.controller.dto.ParkingCreateDTO;
import com.g.aleprojetos.parking.controller.dto.ParkingDTO;
import com.g.aleprojetos.parking.controller.mapper.ParkingMapper;
import com.g.aleprojetos.parking.model.Parking;
import com.g.aleprojetos.parking.service.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @PostMapping
    @ApiOperation("Create parking")
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto){

        Parking parkingCreate = parkingMapper.toParkingCreate(dto);
        Parking parking =  parkingService.create(parkingCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingMapper.ToParkingDTO(parking));
    }

    @GetMapping
    @ApiOperation("Find all parking")
    public ResponseEntity<List<ParkingDTO>> findAll(){

       List<Parking> parkingList =  parkingService.findAll();
        return ResponseEntity.ok(parkingMapper.toParkingDTOList(parkingList));
    }

    @GetMapping("/{id}")
    @ApiOperation("Find parking for id")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id){

        Parking parking =  parkingService.findById(id);
        return ResponseEntity.ok(parkingMapper.ToParkingDTO(parking));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update parking")
    public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO dto){

        Parking parkingUpdate = parkingMapper.toParkingCreate(dto);
        Parking parking =  parkingService.update(id, parkingUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(parkingMapper.ToParkingDTO(parking));
    }

    @PutMapping("/exit/{id}")
    @ApiOperation("Exit")
    public ResponseEntity<ParkingDTO> exit(@PathVariable String id){

        Parking parking =  parkingService.exit(id);
        return ResponseEntity.status(HttpStatus.OK).body(parkingMapper.ToParkingDTO(parking));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deleta parking for id")
    public ResponseEntity delete(@PathVariable String id){

        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
