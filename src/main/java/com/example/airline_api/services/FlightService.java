package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.NewFlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PassengerService passengerService;

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

    @Transactional
    public Flight addPassengetToFlight(Long flightId, NewFlightDTO newFlightDTO) {
        Flight flight = flightRepository.findById(flightId).get();
        for (Long passengerIds : newFlightDTO.getPassengerIds()){
            Passenger passenger = passengerRepository.findById(passengerIds).get();
            flight.addPassenger(passenger);
        }
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

}
