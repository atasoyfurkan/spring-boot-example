// package com.atasoy.examplewithchatgpt.service;

// import java.util.List;
// import java.util.Map;
// import java.util.Objects;

// import com.atasoy.examplewithchatgpt.dto.BookOutputDTO;
// import com.atasoy.examplewithchatgpt.dto.BookInputDTO;
// import com.atasoy.examplewithchatgpt.mapper.BookMapper;
// import com.atasoy.examplewithchatgpt.model.Author;
// import com.atasoy.examplewithchatgpt.model.Book;
// import com.atasoy.examplewithchatgpt.repository.AuthorRepository;
// import com.atasoy.examplewithchatgpt.repository.BookRepository;
// import org.springframework.stereotype.Service;

// import com.fasterxml.jackson.databind.JsonMappingException;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import java.util.stream.Collectors;

// @Service
// public class BookService {
// private final BookRepository bookRepository;
// private final AuthorRepository authorRepository;
// private final BookMapper bookMapper;
// private final ObjectMapper objectMapper;

// public BookService(BookRepository bookRepository, AuthorRepository
// authorRepository, BookMapper bookMapper,
// ObjectMapper objectMapper) {
// this.bookRepository = bookRepository;
// this.authorRepository = authorRepository;
// this.bookMapper = bookMapper;
// this.objectMapper = objectMapper;
// }

// public List<BookOutputDTO> getAllBooks() {
// return
// bookRepository.findAll().stream().map(bookMapper::toOutputBookDTO).collect(Collectors.toList());
// }

// public BookOutputDTO getBookById(Long id) {
// Book book = bookRepository.findById(id).orElse(null);
// return bookMapper.toOutputBookDTO(book);
// }

// public BookOutputDTO createBook(BookInputDTO bookInputDTO) {
// Book book = bookMapper.toBook(bookInputDTO);
// authorRepository.save(book.getAuthor());
// Book savedBook = bookRepository.save(book);
// return bookMapper.toOutputBookDTO(savedBook);
// }

// // public BookOutputDTO updateBook(Long id, BookInputDTO bookInputDTO) {
// // Book book = bookRepository.findById(id).orElse(null);
// // if (book == null) {
// // return null;
// // }
// // book = bookMapper.updateBookFromInputDto(bookInputDTO, book);
// // Book savedBook = bookRepository.save(book);
// // return bookMapper.toOutputBookDTO(savedBook);
// // }

// // public BookOutputDTO updatePartialBook(Long id, Map<String, Object>
// values)
// // throws JsonMappingException {
// // Book book = bookRepository.findById(id).orElse(null);
// // if (book == null) {
// // return null;
// // }

// // objectMapper.updateValue(book, values);

// // Book savedBook = bookRepository.save(book);
// // return bookMapper.toOutputBookDTO(savedBook);
// // }

// // public boolean deleteBook(Long id) {
// // if (!bookRepository.existsById(id)) {
// // return false;
// // }

// // bookRepository.deleteById(id);
// // return true;
// // }
// }
