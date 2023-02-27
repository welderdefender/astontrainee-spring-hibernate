package ru.example.astonhibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.astonhibernate.model.dto.user.UserDtoRq;
import ru.example.astonhibernate.model.dto.user.UserDtoRs;
import ru.example.astonhibernate.model.mapper.UserMapper;
import ru.example.astonhibernate.repository.UserRepository;
import ru.example.astonhibernate.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDtoRs> getAllUser() {
        return userRepository.getAllUser()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveOrUpdateUser(UserDtoRq userDtoRq) {
        userRepository.saveOrUpdateUser(userMapper.fromDto(userDtoRq));
    }

    @Override
    public UserDtoRs getUserById(Integer id) {
        return userMapper.toDto(userRepository.getUserById(id));
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteUser(id);
    }
}