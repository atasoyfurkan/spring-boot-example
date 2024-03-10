package com.atasoy.examplewithchatgpt.mapper;

import com.atasoy.examplewithchatgpt.dto.UserInputDTO;
import com.atasoy.examplewithchatgpt.dto.UserOutputDTO;
import com.atasoy.examplewithchatgpt.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "password", source = "password", qualifiedByName = "encodePassword")
    public abstract User toEntity(UserInputDTO userInputDTO);

    @Named("encodePassword")
    String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public abstract UserOutputDTO toOutputDTO(User user);
}
