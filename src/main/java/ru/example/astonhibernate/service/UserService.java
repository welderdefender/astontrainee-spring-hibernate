package ru.example.astonhibernate.service;

import ru.example.astonhibernate.model.dto.user.UserDtoRq;
import ru.example.astonhibernate.model.dto.user.UserDtoRs;

import java.util.List;

public interface UserService {
    List<UserDtoRs> getAllUser();

    void saveOrUpdateUser(UserDtoRq userDtoRq);

    UserDtoRs getUserById(Integer id);

    void deleteUser(Integer id);
}