package com.atasoy.examplewithchatgpt.service;

import com.atasoy.examplewithchatgpt.dto.UserInputDTO;
import com.atasoy.examplewithchatgpt.dto.UserOutputDTO;
import com.atasoy.examplewithchatgpt.mapper.UserMapper;
import com.atasoy.examplewithchatgpt.model.User;
import com.atasoy.examplewithchatgpt.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserOutputDTO createUser(UserInputDTO dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            return null;
        }

        User user = userMapper.toEntity(dto);
        User savedUser = userRepository.save(user);

        return userMapper.toOutputDTO(savedUser);
    }
}
