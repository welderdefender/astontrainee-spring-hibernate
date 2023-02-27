package ru.example.astonhibernate.service;

import ru.example.astonhibernate.model.dto.airportCodes.AirportCodesDtoRq;
import ru.example.astonhibernate.model.dto.airportCodes.AirportCodesDtoRs;

import java.util.List;

public interface AirportCodesService {
    void saveOrUpdateAirportCodes(AirportCodesDtoRq airportCodesDtoRq);

    List<AirportCodesDtoRs> getAllAirportCodes();

    AirportCodesDtoRs getAirportCodesById(Integer id);

    void deleteAirportCodes(Integer id);
}