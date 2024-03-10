package com.atasoy.examplewithchatgpt.repository;

import com.atasoy.examplewithchatgpt.model.Book;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(attributePaths = "author")
    Optional<Book> findById(Long id);
}
