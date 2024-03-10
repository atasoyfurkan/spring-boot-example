package com.atasoy.examplewithchatgpt.dto;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserOutputDTO {
    private Long id;
    private String username;
    private Set<String> roles;
}
