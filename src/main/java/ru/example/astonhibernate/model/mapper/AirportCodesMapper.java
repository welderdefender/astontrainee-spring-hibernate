package ru.example.astonhibernate.model.mapper;

import org.springframework.stereotype.Component;
import ru.example.astonhibernate.model.AirportCodes;
import ru.example.astonhibernate.model.dto.airportCodes.AirportCodesDtoRq;
import ru.example.astonhibernate.model.dto.airportCodes.AirportCodesDtoRs;

@Component
public class AirportCodesMapper {

    public AirportCodesDtoRs toDto(AirportCodes airportCodes) {
        return new AirportCodesDtoRs(airportCodes.getAirportCodeId(),
                airportCodes.getAirportCodeName());
    }

    public AirportCodes fromDto(AirportCodesDtoRq airportCodesDtoRq) {
        return new AirportCodes(airportCodesDtoRq.getAirportCodeId(),
                airportCodesDtoRq.getAirportCodeName());
    }
}