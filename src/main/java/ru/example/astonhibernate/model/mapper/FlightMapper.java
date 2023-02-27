package ru.example.astonhibernate.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.example.astonhibernate.model.AirportCodes;
import ru.example.astonhibernate.model.Company;
import ru.example.astonhibernate.model.Flight;
import ru.example.astonhibernate.model.User;
import ru.example.astonhibernate.model.dto.flight.FlightDtoRq;
import ru.example.astonhibernate.model.dto.flight.FlightDtoRs;
import ru.example.astonhibernate.model.dto.users_flights.UsersFlightsDtoRs;
import ru.example.astonhibernate.repository.AirportCodesRepository;
import ru.example.astonhibernate.repository.CompanyRepository;

@Component
public class FlightMapper {
    private final CompanyRepository companyRepository;
    private final AirportCodesRepository airportCodesRepository;

    @Autowired
    public FlightMapper(CompanyRepository companyRepository, AirportCodesRepository airportCodesRepository) {
        this.companyRepository = companyRepository;
        this.airportCodesRepository = airportCodesRepository;
    }

    public Flight fromDto(FlightDtoRq flightDtoRq) {
        Company company = companyRepository.findCompanyById(flightDtoRq.getCompany());
        AirportCodes airportCodes = airportCodesRepository.findAirportCodesById(flightDtoRq.getAirportCodes());
        return new Flight.Builder()
                .setFlightId(flightDtoRq.getFlightId())
                .setCompany(company)
                .setAirportCodes(airportCodes)
                .setFlightDate(flightDtoRq.getFlightDate())
                .setFlightFrom(flightDtoRq.getFlightFrom())
                .setFlightTo(flightDtoRq.getFlightTo())
                .build();
    }

    public FlightDtoRs toDto(Flight flight) {
        return new FlightDtoRs(flight.getFlightId(),
                flight.getCompany().getCompanyId(),
                flight.getAirportCodes().getAirportCodeId(),
                flight.getFlightDate(),
                flight.getFlightFrom(),
                flight.getFlightTo());
    }

    public UsersFlightsDtoRs toUsersFlightsDto(User user, Flight flight) {
        return new UsersFlightsDtoRs(user.getUserId(),
                flight.getFlightId(),
                user.getName(),
                user.getAge());
    }
}