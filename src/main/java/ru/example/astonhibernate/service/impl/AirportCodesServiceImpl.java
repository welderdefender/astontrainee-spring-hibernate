package ru.example.astonhibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.astonhibernate.model.dto.airportCodes.AirportCodesDtoRq;
import ru.example.astonhibernate.model.dto.airportCodes.AirportCodesDtoRs;
import ru.example.astonhibernate.model.mapper.AirportCodesMapper;
import ru.example.astonhibernate.repository.AirportCodesRepository;
import ru.example.astonhibernate.service.AirportCodesService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportCodesServiceImpl implements AirportCodesService {
    private final AirportCodesRepository airportCodesRepository;
    private final AirportCodesMapper airportCodesMapper;

    @Autowired
    public AirportCodesServiceImpl(AirportCodesRepository airportCodesRepository,
                                   AirportCodesMapper airportCodesMapper) {
        this.airportCodesRepository = airportCodesRepository;
        this.airportCodesMapper = airportCodesMapper;
    }

    @Override
    public void saveOrUpdateAirportCodes(AirportCodesDtoRq airportCodesDtoRq) {
        airportCodesRepository.saveOrUpdateAirportCodes(airportCodesMapper.fromDto(airportCodesDtoRq));
    }

    @Override
    public List<AirportCodesDtoRs> getAllAirportCodes() {
        return airportCodesRepository.getAllAirportCodes()
                .stream()
                .map(airportCodesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AirportCodesDtoRs getAirportCodesById(Integer id) {
        return airportCodesMapper.toDto(airportCodesRepository.findAirportCodesById(id));
    }

    @Override
    public void deleteAirportCodes(Integer id) {
        airportCodesRepository.deleteAirportCodesById(id);
    }
}