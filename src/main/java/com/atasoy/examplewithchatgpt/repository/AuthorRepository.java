package com.atasoy.examplewithchatgpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atasoy.examplewithchatgpt.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
