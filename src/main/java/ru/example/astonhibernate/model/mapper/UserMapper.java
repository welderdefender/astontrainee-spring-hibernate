package ru.example.astonhibernate.model.mapper;

import org.springframework.stereotype.Component;
import ru.example.astonhibernate.model.User;
import ru.example.astonhibernate.model.dto.user.UserDtoRq;
import ru.example.astonhibernate.model.dto.user.UserDtoRs;

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
}