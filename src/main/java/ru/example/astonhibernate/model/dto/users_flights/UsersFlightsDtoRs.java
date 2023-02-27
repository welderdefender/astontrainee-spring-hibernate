package ru.example.astonhibernate.model.dto.users_flights;

public class UsersFlightsDtoRs {
    private Integer userId;
    private Integer flightId;
    private String userName;
    private Integer userAge;

    public UsersFlightsDtoRs(Integer userId, Integer flightId, String userName, Integer userAge) {
        this.userId = userId;
        this.flightId = flightId;
        this.userName = userName;
        this.userAge = userAge;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "UsersFlightsDtoRs{" +
                "userId=" + userId +
                ", flightId=" + flightId +
                ", userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                '}';
    }
}