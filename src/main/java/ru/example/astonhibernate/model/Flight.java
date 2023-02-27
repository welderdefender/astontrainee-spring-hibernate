package ru.example.astonhibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "airport_code_id")
    private AirportCodes airportCodes;

    @Column(name = "flight_date")
    private String flightDate;

    @Column(name = "flight_from")
    private String flightFrom;

    @Column(name = "flight_to")
    private String flightTo;

    @ManyToMany(mappedBy = "flights")
    private List<User> users;

    public Flight() {
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public AirportCodes getAirportCodes() {
        return airportCodes;
    }

    public void setAirportCodes(AirportCodes airportCodes) {
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public static class Builder {
        private Integer flightId;
        private Company company;
        private AirportCodes airportCodes;
        private String flightDate;
        private String flightFrom;
        private String flightTo;

        public Builder() {
        }

        public void setFlightId(Integer flightId) {
            this.flightId = flightId;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        public void setAirportCodes(AirportCodes airportCodes) {
            this.airportCodes = airportCodes;
        }

        public void setFlightDate(String flightDate) {
            this.flightDate = flightDate;
        }

        public void setFlightFrom(String flightFrom) {
            this.flightFrom = flightFrom;
        }

        public void setFlightTo(String flightTo) {
            this.flightTo = flightTo;
        }

        public Flight build() {
            Flight flight = new Flight();
            flight.flightId = this.flightId;
            flight.company = this.company;
            flight.airportCodes = this.airportCodes;
            flight.flightDate = this.flightDate;
            flight.flightFrom = this.flightFrom;
            flight.flightTo = this.flightTo;
            return flight;
        }
    }
}