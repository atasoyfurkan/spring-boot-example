package com.atasoy.examplewithchatgpt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookInputDTO {
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotNull(message = "Author is mandatory")
    private String authorId;
}
