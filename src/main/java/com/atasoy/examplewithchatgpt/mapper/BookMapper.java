package com.atasoy.examplewithchatgpt.mapper;

import com.atasoy.examplewithchatgpt.dto.BookInputDTO;
import com.atasoy.examplewithchatgpt.dto.BookOutputDTO;
import com.atasoy.examplewithchatgpt.model.Author;
import com.atasoy.examplewithchatgpt.model.Book;
import com.atasoy.examplewithchatgpt.repository.AuthorRepository;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Mapper(componentModel = "spring")
public abstract class BookMapper {

    @Autowired
    private AuthorRepository authorRepository;

    @Mapping(target = "author", source = "authorId", qualifiedByName = "authorIdToAuthor")
    @Mapping(target = "id", ignore = true)
    public abstract Book toEntity(BookInputDTO dto);

    @Mapping(target = "author", source = "authorId", qualifiedByName = "authorIdToAuthor")
    @Mapping(target = "id", ignore = true)
    public abstract void updateEntity(BookInputDTO dto, @MappingTarget Book book);

    @Named("authorIdToAuthor")
    Author authorIdToAuthor(String id) {
        return authorRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
    }

    public abstract BookOutputDTO toOutputDTO(Book book);

}