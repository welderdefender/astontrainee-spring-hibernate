package ru.example.astonhibernate.model.dto.users_flights;

public class UsersFlightsDtoRq {
    private Integer userId;
    private Integer flightId;

    public UsersFlightsDtoRq(Integer userId, Integer flightId) {
        this.userId = userId;
        this.flightId = flightId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "UsersFlightsDtoRq{" +
                "userId=" + userId +
                ", flightId=" + flightId +
                '}';
    }
}