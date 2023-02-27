package ru.example.astonhibernate.service;

import ru.example.astonhibernate.model.AirportCodes;

import java.util.List;

public interface AirportCodesService {
    public void addAirportCode(AirportCodes airportCodes);
    public void updateAirportCode(AirportCodes airportCodes);
    public void removeAirportCode(int id);
    public AirportCodes getById(int id);
    public List<AirportCodes> listOfAirportCodes();
}
