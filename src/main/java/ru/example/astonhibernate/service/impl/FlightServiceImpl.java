package ru.example.astonhibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.astonhibernate.model.Flight;
import ru.example.astonhibernate.model.User;
import ru.example.astonhibernate.model.dto.flight.FlightDtoRq;
import ru.example.astonhibernate.model.dto.flight.FlightDtoRs;
import ru.example.astonhibernate.model.dto.users_flights.UsersFlightsDtoRq;
import ru.example.astonhibernate.model.dto.users_flights.UsersFlightsDtoRs;
import ru.example.astonhibernate.model.mapper.FlightMapper;
import ru.example.astonhibernate.repository.FlightRepository;
import ru.example.astonhibernate.service.FlightService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    @Override
    public List<FlightDtoRs> getAllFlight() {
        return flightRepository.getAllFlights()
                .stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveOrUpdateFlight(FlightDtoRq flightDtoRq) {
        flightRepository.saveOrUpdateFlight(flightMapper.fromDto(flightDtoRq));
    }

    @Override
    public FlightDtoRs getFlightById(Integer id) {
        return flightMapper.toDto(flightRepository.getFlightById(id));
    }

    @Override
    public void deleteFlight(Integer id) {
        flightRepository.deleteFlightById(id);
    }

    @Override
    public List<UsersFlightsDtoRs> getUsersFlights() {
        List<UsersFlightsDtoRs> usersFlightsDtoRs = new ArrayList<>();
        List<Flight> userFlights = flightRepository.getUsersFlights();
        for (Flight flight : userFlights) {
            for (User user : flight.getUsers()) {
                UsersFlightsDtoRs usersFlightsDto = flightMapper.toUsersFlightsDto(user, flight);
                usersFlightsDtoRs.add(usersFlightsDto);
            }
        }
        return usersFlightsDtoRs;
    }

    @Override
    public void deleteUsersFlights(Integer user_id, Integer flight_id) {
        flightRepository.deleteUsersFlights(user_id, flight_id);
    }

    @Override
    public void saveUsersFlights(UsersFlightsDtoRq usersFlightsDtoRq) {
        flightRepository.saveUsersFlights(usersFlightsDtoRq);
    }
}