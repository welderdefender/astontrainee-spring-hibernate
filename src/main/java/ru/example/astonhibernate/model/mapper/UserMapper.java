package ru.example.astonhibernate.model.mapper;

import org.springframework.stereotype.Component;
import ru.example.astonhibernate.model.Flight;
import ru.example.astonhibernate.model.User;
import ru.example.astonhibernate.model.dto.user.UserDtoRq;
import ru.example.astonhibernate.model.dto.user.UserDtoRs;
import ru.example.astonhibernate.model.dto.users_flights.UsersFlightsDtoRs;

@Component
public class UserMapper {
    public UserDtoRs toDto(User user) {
        return new UserDtoRs(user.getUserId(),
                user.getName(),
                user.getAge());
    }

    public User fromDto(UserDtoRq userDtoRq) {
        return new User(userDtoRq.getUserId(),
                userDtoRq.getName(),
                userDtoRq.getAge());
    }

    public UsersFlightsDtoRs toUsersFlightsDto(User user, Flight flight) {
        return new UsersFlightsDtoRs(user.getUserId(),
                flight.getFlightId(),
                user.getName(),
                user.getAge());
    }
}