package ru.example.astonhibernate.model.dto.flight;

public class FlightDtoRs {
    private int flightId;
    private Integer company;
    private Integer airportCodes;
    private String flightDate;
    private String flightFrom;
    private String flightTo;

    public FlightDtoRs(int flightId, Integer company, Integer airportCodes, String flightDate, String flightFrom,
                       String flightTo) {
        this.flightId = flightId;
        this.company = company;
        this.airportCodes = airportCodes;
        this.flightDate = flightDate;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getAirportCodes() {
        return airportCodes;
    }

    public void setAirportCodes(Integer airportCodes) {
        this.airportCodes = airportCodes;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }
}