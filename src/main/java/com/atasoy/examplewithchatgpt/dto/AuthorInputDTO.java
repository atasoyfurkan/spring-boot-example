package com.atasoy.examplewithchatgpt.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorInputDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;
}
