package com.example.aviastrela;

public class FlightSchedule {
    private String departureDate;
    private String flightTime;
    private String airline;
    private String status;
    private String flightNumber;
    private String actualDepartureTime;
    private String actualArrivalTime;

    public FlightSchedule(String departureDate, String flightTime, String airline, String status,
                          String flightNumber, String actualDepartureTime, String actualArrivalTime) {
        this.departureDate = departureDate;
        this.flightTime = flightTime;
        this.airline = airline;
        this.status = status;
        this.flightNumber = flightNumber;
        this.actualDepartureTime = actualDepartureTime;
        this.actualArrivalTime = actualArrivalTime;
    }

    // Геттеры
    public String getDepartureDate() { return departureDate; }
    public String getFlightTime() { return flightTime; }
    public String getAirline() { return airline; }
    public String getStatus() { return status; }
    public String getFlightNumber() { return flightNumber; }
    public String getActualDepartureTime() { return actualDepartureTime; }
    public String getActualArrivalTime() { return actualArrivalTime; }
}