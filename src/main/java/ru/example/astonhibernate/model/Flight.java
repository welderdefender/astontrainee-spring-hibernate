package ru.example.astonhibernate.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;

    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "airport_code")
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

        public Builder setFlightId(Integer flightId) {
            this.flightId = flightId;
            return this;
        }

        public Builder setCompany(Company company) {
            this.company = company;
            return this;
        }

        public Builder setAirportCodes(AirportCodes airportCodes) {
            this.airportCodes = airportCodes;
            return this;
        }

        public Builder setFlightDate(String flightDate) {
            this.flightDate = flightDate;
            return this;
        }

        public Builder setFlightFrom(String flightFrom) {
            this.flightFrom = flightFrom;
            return this;
        }

        public Builder setFlightTo(String flightTo) {
            this.flightTo = flightTo;
            return this;
        }

        public Flight build() {
            Flight flight = new Flight();
            flight.company = this.company;
            flight.flightId = this.flightId;
            flight.airportCodes = this.airportCodes;
            flight.flightDate = this.flightDate;
            flight.flightFrom = this.flightFrom;
            flight.flightTo = this.flightTo;
            return flight;
        }
    }
}