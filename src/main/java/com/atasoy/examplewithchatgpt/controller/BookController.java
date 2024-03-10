package com.atasoy.examplewithchatgpt.controller;

import com.atasoy.examplewithchatgpt.dto.BookOutputDTO;
import com.atasoy.examplewithchatgpt.dto.BookInputDTO;
import com.atasoy.examplewithchatgpt.service.BookService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookOutputDTO> createBook(@Valid @RequestBody BookInputDTO dto) {
        return new ResponseEntity<>(bookService.createBook(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookOutputDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookOutputDTO> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookOutputDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookInputDTO dto) {
        return ResponseEntity.ok(bookService.updateBook(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
