package com.atasoy.examplewithchatgpt.service;

import java.util.List;

import com.atasoy.examplewithchatgpt.dto.BookOutputDTO;
import com.atasoy.examplewithchatgpt.dto.BookInputDTO;
import com.atasoy.examplewithchatgpt.mapper.BookMapper;
import com.atasoy.examplewithchatgpt.model.Book;
import com.atasoy.examplewithchatgpt.repository.BookRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public BookOutputDTO createBook(BookInputDTO dto) {
        Book book = bookMapper.toEntity(dto);
        book = bookRepository.save(book);
        return bookMapper.bookToBookOutputDTO(book);
    }

    public List<BookOutputDTO> findAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::bookToBookOutputDTO)
                .collect(Collectors.toList());
    }

    public BookOutputDTO findBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        return bookMapper.bookToBookOutputDTO(book);
    }

    public BookOutputDTO updateBook(Long id, BookInputDTO dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        bookMapper.updateEntity(dto, book);
        book = bookRepository.save(book);
        return bookMapper.bookToBookOutputDTO(book);
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        bookRepository.deleteById(id);
    }
}
