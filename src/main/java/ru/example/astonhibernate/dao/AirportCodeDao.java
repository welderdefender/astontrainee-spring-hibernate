package ru.example.astonhibernate.dao;

import ru.example.astonhibernate.model.AirportCodes;

import java.util.List;

public interface AirportCodeDao {
    public void addAirportCode(AirportCodes airportCodes);
    public void updateAirportCode(AirportCodes airportCodes);
    public void removeAirportCode(int id);
    public AirportCodes getById(int id);
    public List<AirportCodes> listOfAirportCodes();

}
