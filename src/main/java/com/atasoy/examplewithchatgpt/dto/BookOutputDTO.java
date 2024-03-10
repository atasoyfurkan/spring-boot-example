package com.atasoy.examplewithchatgpt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookOutputDTO {
    private Long id;
    private String title;
    private AuthorOutputDTO author;
}
