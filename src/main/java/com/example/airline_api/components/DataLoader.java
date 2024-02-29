package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//          FLIGHTS
        Flight flight1 = new Flight("Paris", 200, "01/03/2024", "13:00");
        flightRepository.save(flight1);
        Flight flight2 = new Flight("Rome", 150, "01/10/2024", "14:00");
        flightRepository.save(flight2);
        Flight flight3 = new Flight("Sydney", 220, "10/03/2024", "09:00");
        flightRepository.save(flight3);
        Flight flight4 = new Flight("Tashkent", 170, "15/03/2024", "09:45");
        flightRepository.save(flight4);
        Flight flight5 = new Flight("CapeTown", 185, "10/06/2024", "10:00");
        flightRepository.save(flight5);

//        PASSENGERS
        Passenger passenger1 = new Passenger("Harry", "harry@mail.com");
        passenger1.addFlight(flight1);
        passenger1.addFlight(flight5);
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger("Tim", "tim@mail.com");
        passenger2.addFlight(flight1);
        passengerRepository.save(passenger2);

        Passenger passenger3 = new Passenger("Sarah", "sarah@mail.com");
        passenger3.addFlight(flight4);
        passengerRepository.save(passenger3);

        Passenger passenger4 = new Passenger("Ellie", "ellie@mail.com");
        passenger4.addFlight(flight4);
        passengerRepository.save(passenger4);

        Passenger passenger5 = new Passenger("Jessica", "jessica@mail.com");
        passenger5.addFlight(flight2);
        passenger5.addFlight(flight3);
        passengerRepository.save(passenger5);

        Passenger passenger6 = new Passenger("Sam", "sam@mail.com");
        passenger6.addFlight(flight2);
        passengerRepository.save(passenger6);

        Passenger passenger7 = new Passenger("Alexandra", "alexandra@mail.com");
        passenger7.addFlight(flight5);
        passengerRepository.save(passenger7);

        Passenger passenger8 = new Passenger("Veronica", "veronica@mail.com");
        passenger8.addFlight(flight1);
        passenger8.addFlight(flight4);
        passengerRepository.save(passenger8);

        Passenger passenger9 = new Passenger("Arthur", "arthur@mail.com");
        passenger9.addFlight(flight5);
        passengerRepository.save(passenger9);

    }
}
