package com.example.airline_api.models;

import java.util.ArrayList;
import java.util.List;

public class NewFlightDTO {

    private String destination;
    private int capacity;
    private String departureTime;
    private String departureDate;
    private List<Long> passengerIds;

    public NewFlightDTO() {
    }

    public NewFlightDTO(String destination, int capacity, String departureTime, String departureDate) {
        this.destination = destination;
        this.capacity = capacity;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.passengerIds = new ArrayList<>();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public List<Long> getPassengerIds() {
        return passengerIds;
    }

    public void setPassengerIds(List<Long> passengerIds) {
        this.passengerIds = passengerIds;
    }
}
