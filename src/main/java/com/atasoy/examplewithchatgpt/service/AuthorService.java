package com.atasoy.examplewithchatgpt.service;

import com.atasoy.examplewithchatgpt.mapper.AuthorMapper;
import com.atasoy.examplewithchatgpt.model.Author;
import com.atasoy.examplewithchatgpt.dto.AuthorInputDTO;
import com.atasoy.examplewithchatgpt.dto.AuthorOutputDTO;
import com.atasoy.examplewithchatgpt.repository.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public AuthorOutputDTO createAuthor(AuthorInputDTO dto) {
        Author author = authorMapper.toEntity(dto);
        author = authorRepository.save(author);
        return authorMapper.toOutputDTO(author);
    }

    public List<AuthorOutputDTO> findAllAuthors() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toOutputDTO)
                .collect(Collectors.toList());
    }

    public AuthorOutputDTO findAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
        return authorMapper.toOutputDTO(author);
    }

    public AuthorOutputDTO updateAuthor(Long id, AuthorInputDTO dto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
        author.setName(dto.getName());
        author = authorRepository.save(author);
        return authorMapper.toOutputDTO(author);
    }

    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
        }
        authorRepository.deleteById(id);
    }
}
