package com.atasoy.examplewithchatgpt.mapper;

import com.atasoy.examplewithchatgpt.model.Author;
import com.atasoy.examplewithchatgpt.dto.AuthorInputDTO;
import com.atasoy.examplewithchatgpt.dto.AuthorOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author toEntity(AuthorInputDTO dto);

    AuthorOutputDTO toOutputDTO(Author author);
}
