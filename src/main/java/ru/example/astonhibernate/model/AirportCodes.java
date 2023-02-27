package ru.example.astonhibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "airport_codes")
public class AirportCodes {
    @Id
    @Column(name = "airport_code_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airportCodeId;

    @Column(name = "airport_code_name")
    private String airportCodeName;

    public AirportCodes() {
    }

    public AirportCodes(int airportCodeId, String airportCodeName) {
        this.airportCodeId = airportCodeId;
        this.airportCodeName = airportCodeName;
    }

    public int getAirportCodeId() {
        return airportCodeId;
    }

    public void setAirportCodeId(int airportCodeId) {
        this.airportCodeId = airportCodeId;
    }

    public String getAirportCodeName() {
        return airportCodeName;
    }

    public void setAirportCodeName(String airportCodeName) {
        this.airportCodeName = airportCodeName;
    }

    @Override
    public String toString() {
        return "AirportCodes{" +
                "airportCodeId=" + airportCodeId +
                ", airportCodeName='" + airportCodeName + '\'' +
                '}';
    }
}