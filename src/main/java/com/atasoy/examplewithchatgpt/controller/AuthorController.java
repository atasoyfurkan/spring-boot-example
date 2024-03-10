package com.atasoy.examplewithchatgpt.controller;

import com.atasoy.examplewithchatgpt.dto.AuthorInputDTO;
import com.atasoy.examplewithchatgpt.dto.AuthorOutputDTO;
import com.atasoy.examplewithchatgpt.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorOutputDTO> createAuthor(@Valid @RequestBody AuthorInputDTO dto) {
        return new ResponseEntity<>(authorService.createAuthor(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorOutputDTO>> getAllAuthors() {
        return ResponseEntity.ok(authorService.findAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorOutputDTO> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.findAuthorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorOutputDTO> updateAuthor(@PathVariable Long id, @Valid @RequestBody AuthorInputDTO dto) {
        return ResponseEntity.ok(authorService.updateAuthor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
