package com.example.airline_api.controllers;

import com.example.airline_api.models.NewPassengerDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    // Display details of all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        List<Passenger> passengers = passengerService.getAllPassengers();
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    // Display specific passenger details
    @GetMapping(value = "/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long passengerId){
        Optional<Passenger> passenger = passengerService.getPassengerById(passengerId);
        if (passenger.isPresent()){
            return new ResponseEntity<>(passenger.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Add a new passenger
    @PostMapping
    public ResponseEntity<Passenger> addNewPassenger(@RequestBody NewPassengerDTO newPassengerDTO){
        Passenger passenger = passengerService.savePassenger(newPassengerDTO);
        return new ResponseEntity<>(passenger, HttpStatus.CREATED);
    }

}
