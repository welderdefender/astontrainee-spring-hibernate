package ru.example.astonhibernate.model.dto.airportCodes;

public class AirportCodesDtoRs {
    private int airportCodeId;
    private String airportCodeName;

    public AirportCodesDtoRs(int airportCodeId, String airportCodeName) {
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
}