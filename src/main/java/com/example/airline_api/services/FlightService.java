package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.NewFlightDTO;
import com.example.airline_api.models.NewPassengerDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight saveFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }

    public void cancelFlight(Long id) {
        Flight flight = flightRepository.findById(id).get();

        for (Passenger passenger : flight.getPassengers()){
            passenger.removeFlight(flight);
            passengerRepository.save(passenger);
        }
        flightRepository.delete(flight);
    }

    @Transactional // updateFlightWithPassenger
    public Flight addPassengetToFlight(Long flightId, Long passengerId, NewFlightDTO newFlightDTO) {
        Flight flightToUpdate = flightRepository.findById(flightId);

        flightToUpdate.setDestination(newFlightDTO.getDestination());
        flightToUpdate.setCapacity(newFlightDTO.getCapacity());
        flightToUpdate.setDepartureDate(newFlightDTO.getDepartureDate());
        flightToUpdate.setDepartureTime(newFlightDTO.getDepartureTime());
        flightToUpdate.setPassengers(new ArrayList<>());
        for (Long newPassengerId : newFlightDTO.getPassengerIds()) {
            Passenger passenger = passengerRepository.findById(passengerId).get();
            flightToUpdate.addPassenger(passengerId);
        }

        Passenger passengerToAdd = passengerRepository.findById(passengerId).get();

        passengerToAdd.addFlight(flightToUpdate);
        return flightRepository.save(flightToUpdate);
    }

}
