package ru.example.astonhibernate.service;

import ru.example.astonhibernate.model.dto.flight.FlightDtoRq;
import ru.example.astonhibernate.model.dto.flight.FlightDtoRs;
import ru.example.astonhibernate.model.dto.users_flights.UsersFlightsDtoRq;
import ru.example.astonhibernate.model.dto.users_flights.UsersFlightsDtoRs;

import java.util.List;

public interface FlightService {
    List<FlightDtoRs> getAllFlight();

    void saveOrUpdateFlight(FlightDtoRq flightDtoRq);

    FlightDtoRs getFlightById(Integer id);

    void deleteFlight(Integer id);

    List<UsersFlightsDtoRs> getUsersFlights();

    void deleteUsersFlights(Integer user_id, Integer flight_id);

    void saveUsersFlights(UsersFlightsDtoRq usersFlightsDtoRq);
}