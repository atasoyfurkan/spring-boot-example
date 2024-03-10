package com.atasoy.examplewithchatgpt.controller;

import com.atasoy.examplewithchatgpt.dto.UserInputDTO;
import com.atasoy.examplewithchatgpt.dto.UserOutputDTO;
import com.atasoy.examplewithchatgpt.service.UserService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/public/register")
    public ResponseEntity<UserOutputDTO> registerUser(@Valid @RequestBody UserInputDTO userDTO) {
        UserOutputDTO userOutputDTO = userService.createUser(userDTO);
        if (userOutputDTO == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userOutputDTO, HttpStatus.CREATED);
    }
}
