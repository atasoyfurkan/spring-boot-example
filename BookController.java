// package com.atasoy.examplewithchatgpt.controller;

// import com.atasoy.examplewithchatgpt.dto.BookOutputDTO;
// import com.atasoy.examplewithchatgpt.dto.BookInputDTO;
// import com.atasoy.examplewithchatgpt.service.BookService;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.fasterxml.jackson.databind.JsonMappingException;

// import jakarta.validation.Valid;
// import java.util.List;

// import java.util.Map;

// @RestController
// @RequestMapping("/api/v1/books")
// public class BookController {

// private final BookService bookService;

// public BookController(BookService bookService) {
// this.bookService = bookService;
// }

// @GetMapping
// public List<BookOutputDTO> getAllBooks() {
// return bookService.getAllBooks();
// }

// @GetMapping("/{id}")
// public ResponseEntity<BookOutputDTO> getBookById(@PathVariable Long id) {
// BookOutputDTO book = bookService.getBookById(id);
// if (book == null) {
// return ResponseEntity.notFound().build();
// }
// return ResponseEntity.ok(book);
// }

// @PostMapping
// public ResponseEntity<BookOutputDTO> createBook(@Valid @RequestBody
// BookInputDTO bookInputDTO) {
// BookOutputDTO book = bookService.createBook(bookInputDTO);
// return new ResponseEntity<>(book, HttpStatus.CREATED);
// }

// // @PutMapping("/{id}")
// // public ResponseEntity<BookOutputDTO> updateBook(@PathVariable Long id,
// // @Valid @RequestBody BookInputDTO bookUpdateDTO) {
// // BookOutputDTO book = bookService.updateBook(id, bookUpdateDTO);
// // if (book == null) {
// // return ResponseEntity.notFound().build();
// // }
// // return ResponseEntity.ok(book);
// // }

// // @PatchMapping("/{id}")
// // public ResponseEntity<?> patchBook(@PathVariable Long id,
// // @Valid @RequestBody Map<String, Object> values) throws
// JsonMappingException {
// // try {
// // BookOutputDTO book = bookService.updatePartialBook(id, values);
// // if (book == null) {
// // return ResponseEntity.notFound().build();
// // }
// // return ResponseEntity.ok(book);
// // } catch (JsonMappingException e) {
// // return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
// // }
// // }

// // @DeleteMapping("/{id}")
// // public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
// // boolean deleted = bookService.deleteBook(id);
// // if (!deleted) {
// // return ResponseEntity.notFound().build();
// // }
// // return ResponseEntity.noContent().build();
// // }
// }
